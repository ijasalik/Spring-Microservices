package com.ust.controller;

import java.util.ArrayList;

import java.util.List;

import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ust.entity.Favourite;
import com.fasterxml.jackson.core.JsonParseException;
import com.ust.dto.FavouriteDTO;
import com.ust.dto.Recommendation;
import com.ust.dto.User_data;
import com.ust.exception.FavouriteException;
import com.ust.service.IFavouriteService;

import springfox.documentation.spring.web.json.Json;

@RestController
public class FavouriteController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private IFavouriteService favouriteService;


	@PostMapping(value = "/f/cricapp/favourite/save/{username}/{password}")
	public ResponseEntity<?> saveFavouriteMatch(@RequestBody Favourite favourite, @PathVariable("password") String password,
			@PathVariable("username") String userName) throws Exception {
		try {
			User_data user = restTemplate.getForObject("http://localhost:8083/u/cricapp/p/user/login/"+userName+"/"+password ,
					User_data.class);
		}
		catch(Exception e) {
		return new ResponseEntity<String>("Invalid userId or password / Please register before login", HttpStatus.CONFLICT);
		}
		
			if (favouriteService.findByFavouriteMatchId(userName, favourite.getMatchId()) != null) {
				throw new FavouriteException("The favourite match already exists!!");
			}
			try {
			favourite.setUserName(userName);
			favouriteService.addFavouriteMatch(favourite);
			Recommendation recomendation=new Recommendation();
			restTemplate.postForObject("http://localhost:9120/r/cricapp/recommendation/save/"+favourite.getMatchId(),recomendation,Recommendation.class);
			return new ResponseEntity<Favourite>(favourite, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<Favourite>(favourite, HttpStatus.CREATED);
			
		} 
	}

	@DeleteMapping(value = "/f/cricapp/favourite/delete/{username}/{matchid}")
	public ResponseEntity<?> deleteFavouriteMatch(@PathVariable("username") String userName,
			@PathVariable("matchid") String matchId) throws Exception {
		try {
			Favourite favourite = favouriteService.findByFavouriteMatchId(userName, Integer.parseInt(matchId));
			if (favourite == null) {
				throw new FavouriteException("The favourite match was not found!!");
			}
			favourite.setUserName(userName);
			favouriteService.deleteFavouriteMatch(favourite);
			return new ResponseEntity<Favourite>(favourite, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>("The favourite match is not found or has been deleted!!",
					HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/f/cricapp/favourite/get/{username}")
	public ResponseEntity<?> getFavouriteMatches(@PathVariable("username") String userName) throws Exception {
		List<Favourite> favourites = null;
		try {
			favourites = favouriteService.getAllFavouriteMatches(userName);
			if (favourites == null || favourites.isEmpty()) {
				throw new FavouriteException("The favourite matches was not found!!");
			}
			return new ResponseEntity<List<Favourite>>(favourites, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>("The favourite matches was not found!!", HttpStatus.NOT_FOUND);
		}
	}

}

package com.ust.controller;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ust.dto.MatchDTO;
import com.ust.entity.Recommendation;
import com.ust.exception.RecommendationMatchNotFoundException;
import com.ust.service.IRecommendationService;

@RestController
public class ReccomendationController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private IRecommendationService recommendationService;


	@GetMapping(value = "/r/cricapp/recommendation/get")
	public ResponseEntity<?> getRecommendedMatches() throws Exception {
		try {
			List<Recommendation> recommendations = recommendationService.findAllRecommendedMatches();
			if (recommendations.isEmpty()) {
				throw new RecommendationMatchNotFoundException("The Recommended matches not found!!");
			}
			List<Recommendation> favourites = new ArrayList<Recommendation>(recommendations.size());
			for (Recommendation recommendation : recommendations) {
				favourites.add(recommendation);
			}
			return new ResponseEntity<List<Recommendation>>(favourites, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>("The Recommended matches not found!!", HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping(value = "/r/cricapp/recommendation/save/{matchid}")
	public ResponseEntity<String> saveRecommendedMatch(@PathVariable("matchid") String matchId) throws Exception {
		try {
			recommendationService.addRecommendationMatch(Integer.parseInt(matchId));
			return new ResponseEntity<String>("Recommended match has been added!!", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
		}
	}

	@DeleteMapping(value = "/r/cricapp/recommendation/delete/{matchid}")
	public ResponseEntity<String> updateRecommendedMatch(@PathVariable("matchid") String matchId) throws Exception {
		try {
			recommendationService.updateRecommendationMatch(Integer.parseInt(matchId));
			return new ResponseEntity<String>("The Recommendation match has been deleted!!", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
		}
	}


}

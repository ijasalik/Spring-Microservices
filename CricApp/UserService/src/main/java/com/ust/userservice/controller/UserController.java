package com.ust.userservice.controller;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ust.userservice.dto.CrickScore;
import com.ust.userservice.dto.CurrentMatches;
import com.ust.userservice.dto.EventDTO;
import com.ust.userservice.dto.EventDTOs;
import com.ust.userservice.dto.Match;
import com.ust.userservice.dto.Matches;
import com.ust.userservice.dto.OldMatches;
import com.ust.userservice.dto.UserDetails;
import com.ust.userservice.entity.CurrentMatch;
import com.ust.userservice.entity.User;

import com.ust.userservice.service.UserService;
import com.ust.userservice.util.UserUtil;

@RestController
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private RestTemplate restTemplate;
	@GetMapping("/u/cricapp/p")
	public String home() {
		return("<h1>Welcome</h1>");
	}

	@PostMapping("/u/cricapp/user/reg")
	public User register(@RequestBody User userData) {

		User user = userService.register(userData);
		return user;

	}

	@GetMapping("/u/cricapp/p/user/login/{username}/{password}")
	public User Userlogin(@PathVariable("username") String username, @PathVariable("password") String upassword) {
		logger.info("Inside controller id:" + username);
		User curruser = userService.findByUserNameAndPassword(username, upassword);
		return curruser;

	}

	@GetMapping("/u/cricapp/user/upcomingmatches")
	public EventDTOs getUpcomingMatches() {
		logger.info("upcoming matches........");
		List<EventDTO> events = new ArrayList<EventDTO>();
		Matches matches = restTemplate.getForObject(
				"https://cricket.sportmonks.com/api/v2.0/fixtures?api_token=NZkPEAiCVDVabKol6KQa25ouarqncMaYtmKAqwhjB1UDghF0cU9RaEtYh40X",
				Matches.class);
		for (Match matchDTO : matches.getMatches()) {
			EventDTO event = new EventDTO();
			event.setTitle(matchDTO.getName());
			event.setId(matchDTO.getId());
			event.setDate(matchDTO.getDate());
			events.add(event);
		}
		EventDTOs eventsDTO = new EventDTOs();
		eventsDTO.setEvents(events);
		return eventsDTO;

	}

	@GetMapping("/u/cricapp/user/oldmatches")
	public List<Match> getOldMatches() {
		List<Match> events = new ArrayList<Match>();
		OldMatches matches = restTemplate.getForObject(
				"https://cricket.sportmonks.com/api/v2.0/fixtures?api_token=NZkPEAiCVDVabKol6KQa25ouarqncMaYtmKAqwhjB1UDghF0cU9RaEtYh40X",
				OldMatches.class);
		List<Match> oldMatch = matches.getOldMatches();
		Integer count = 0;
		for (Match matchDTO : matches.getOldMatches()) {
			Match matchDetails = new Match();
			System.out.println(matchDTO);
			if (matchDTO != null) {
				matchDetails.setId(matchDTO.getId());
				matchDetails.setName(matchDTO.getName());
				matchDetails.setTeamOne(matchDTO.getTeamOne());
				matchDetails.setTeamTwo(matchDTO.getTeamTwo());
				matchDetails.setToss(matchDTO.getToss());
				matchDetails.setType(matchDTO.getType());
				matchDetails.setWinner(matchDTO.getWinner());
				matchDetails.setDate(matchDTO.getDate());

				events.add(matchDetails);
				count++;

				if (count > 5) {
					break;
				}
			}
		}
		return events;

	}

	@GetMapping("/u/cricapp/user/currentmatches")
	public List<CurrentMatch> currentMatches() {
		List<CurrentMatch> currMatch = userService.getCurrentMatch();
		return currMatch;

	}
	


}

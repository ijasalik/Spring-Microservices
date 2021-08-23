package com.ust.service;

import java.util.List;


import com.ust.entity.Favourite;

public interface IFavouriteService {

public Favourite findByFavouriteMatchId(String userName, Integer id);
	
	public Favourite addFavouriteMatch(Favourite favourite);
	
	public void deleteFavouriteMatch(Favourite favourite);
	
	public List<Favourite> getAllFavouriteMatches(String userName);
}

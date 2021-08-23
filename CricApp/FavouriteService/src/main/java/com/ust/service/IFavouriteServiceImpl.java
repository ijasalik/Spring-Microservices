package com.ust.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.entity.Favourite;
import com.ust.repository.IFavouriteServiceRepository;

@Service
public class IFavouriteServiceImpl implements IFavouriteService{

	@Autowired
	private IFavouriteServiceRepository favouriteRepository;
	
	public IFavouriteServiceImpl(IFavouriteServiceRepository favouriteRepository) {
		this.favouriteRepository = favouriteRepository;
	}
	
	@Override
	public Favourite findByFavouriteMatchId(String userName, Integer id) {
		return favouriteRepository.findByUserNameAndMatchId(userName, id);
	}

	@Override
	public Favourite addFavouriteMatch(Favourite favourite) {
		return favouriteRepository.save(favourite);
	}

	@Override
	public void deleteFavouriteMatch(Favourite favourite) {
		favouriteRepository.delete(favourite);
	}

	@Override
	public List<Favourite> getAllFavouriteMatches(String userName) {
		return favouriteRepository.findAllFavouriteMatchesByUserName(userName);
	}

}

package com.ust.favouriteservice;


import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.ust.dto.User_data;
import com.ust.entity.Favourite;
import com.ust.repository.IFavouriteServiceRepository;
import com.ust.service.IFavouriteServiceImpl;

public class IFavouriteServiceImplTest {
	
	public IFavouriteServiceImplTest() {

	}


	@Mock
	private IFavouriteServiceRepository favouriteServiceRepo;
	
    @InjectMocks
    private IFavouriteServiceImpl favouriteServiceImpl;
	
	private User_data user;
	private Favourite favourite;
	private List<Favourite> favourites;

	@Before
    public void setUp(){
		MockitoAnnotations.initMocks(this);
		
		user = new User_data();
		user.setFirstName("Christy");
		user.setLastName("Thomas");
		user.setPassword("1234");
		user.setUserName("Christy123");
	
		
		favourite = new Favourite();

		favourite.setMatchId(123);
		favourite.setUserName("Christy123");
		favourite.setType("T20");
		favourite.setTeamOne("india");;
		favourite.setTeamTwo("Bangladesh");
		favourite.setName("ind vs bng, t20 match");
		favourite.setToss("India");
		favourite.setType("T20");
		favourite.setWinner("India");
		favourite.setDate(new Date().toString());
		
		favourites = new ArrayList<Favourite>();
		favourites.add(favourite);
		
		favourite.setMatchId(125);
		favourite.setUserName("Christy123");
		favourite.setType("T20");
		favourite.setTeamOne("india");;
		favourite.setTeamTwo("pakistaN");
		favourite.setName("ind vs Pak, t20 match");
		favourite.setToss("India");
		favourite.setType("T20");
		favourite.setWinner("India");
		favourite.setDate(new Date().toString());
		
		favourites.add(favourite);
    }
    @After
    public void tearDown(){
    	user = null;
    	favourite = null;
    }



	@Test
	public void testFindByFavouriteMatchId() {
        Mockito.when(favouriteServiceRepo.findByUserNameAndMatchId(favourite.getUserName(), favourite.getMatchId())).thenReturn(favourite);
        Favourite fav = favouriteServiceImpl.findByFavouriteMatchId(favourite.getUserName(), favourite.getMatchId());
        Assert.assertEquals(favourite, fav);
	}

	@Test
	public void testAddFavouriteMatch() {
        Mockito.when(favouriteServiceRepo.save(favourite)).thenReturn(favourite);
        Favourite fav = favouriteServiceImpl.addFavouriteMatch(favourite);
        Assert.assertEquals(favourite, fav);
	}


	@Test
	public void testGetAllFavouriteMatches() {
        Mockito.when(favouriteServiceRepo.findAllFavouriteMatchesByUserName(favourite.getUserName())).thenReturn(favourites);
        List<Favourite> favs = favouriteServiceImpl.getAllFavouriteMatches(favourite.getUserName());
        Assert.assertEquals(favourites, favs);
	}

}

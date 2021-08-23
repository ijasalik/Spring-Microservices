package com.ust.userservice;




import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.ust.userservice.dao.UserDao;
import com.ust.userservice.entity.User;
import com.ust.userservice.service.UserServiceImpl;



public class UserServiceImplTest {
	
	public UserServiceImplTest() {
	}

	@Mock
    private UserDao userServiceRepository;
    private User user;

    @InjectMocks
    private UserServiceImpl userService;


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        user = new User();
		user.setFirstName("Christy");
		user.setLastName("Thomas");
		user.setPassword("123");
		user.setUserName("christy123");
    }
    @After
    public void tearDown(){
    	user = null;
    }

	@Test
	public void testRegister() {
        Mockito.when(userServiceRepository.save(user)).thenReturn(user);
        User isUserCreated = userService.register(user);
        Assert.assertEquals(user, isUserCreated);
	}

	@Test
	public void testFindByFirstnameAndPassword() {
        Mockito.when(userServiceRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword())).thenReturn(user);
        User usr = userService.findByUserNameAndPassword(user.getUserName(), user.getPassword());
        Assert.assertEquals(user, usr);
	}

}

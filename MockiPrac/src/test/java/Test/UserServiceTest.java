package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import Mock.UserDao;
import Mock.UserService;
import Mock.Users;

public class UserServiceTest {
	@Test
	public void typeOfUser() {
		// step 1 :  create mock object 
		UserDao ud = mock(UserDao.class) ;
		
		// step 2 : // create fake object 
		
		Users fake = new Users() ;  // fake object we are creating
		fake.setBalance(2000);
		fake.setId(1);
		fake.setName("Allen");
		when(ud.findById(1)).thenReturn(fake) ;  // create fake object and simply return it
		
		UserService service = new UserService(ud);   
		String ans = service.typeOfUser(1) ;
		assertEquals("regular User",ans) ;
	}

	
}

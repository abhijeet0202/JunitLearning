package rameshNotes;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import mockit.*;
import rameshNotes.DbHelper;
import rameshNotes.User;

public class UserTest {
	@Mocked DbHelper dbH;
	User user = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		user = new User(dbH);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStoreData_UserExists_CorrectAge() {
		new Expectations() {{
			dbH.IsUserExists("Ramesh"); result = true;
			dbH.GetAge(); result = 30;
		}};

		boolean result = user.StoreData("Ramesh", 30);
		assertTrue(result);
	}

	@Test
	public void testStoreData_UserExists_IncorrectAge() {
		new StrictExpectations() {{
			dbH.IsUserExists(anyString); result = true; maxTimes=1;
			dbH.GetAge(); result = 25;
		}};

		boolean result = user.StoreData("Ramesh", 30);
		assertTrue(result);
		
		new Verifications() {{
			dbH.SetAge(30);
		}};
	}
	
	@Test
	public void testStoreData_UserNotExists_DbUpdateSuccess() {
		new StrictExpectations() {{
			dbH.IsUserExists("Ramesh"); returns(false, true); times=2;
		}};
		
		boolean result = user.StoreData("Ramesh", 30);
		assertTrue(result);
		
		new Verifications() {{
			dbH.SetUserName("Ramesh");
			dbH.SetAge(anyInt);
		}};
	}
	
	@Test
	public void testStoreData_UserNotExists_DbUpdateFailure() {
		new StrictExpectations() {{
			dbH.IsUserExists("Ramesh"); returns(false, false); minTimes=1;
		}};
		
		boolean result = user.StoreData("Ramesh", 30);
		assertFalse(result);
		
		new Verifications() {{
			dbH.SetUserName(withSubstring("Ram"));
			dbH.SetAge(anyInt);
		}};
	}
}

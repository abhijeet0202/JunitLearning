package rameshNotes;


import static org.junit.Assert.*;

import org.junit.Test;

import rameshNotes.DbHelper;


public class DbHelperTest {

	@Test
	public void testIsUserExists() {
		DbHelper dbH = new DbHelper();
		
		boolean result = dbH.IsUserExists("Ramesh");
		assertFalse(result);
	}

}

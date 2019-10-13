package rameshNotes;

public class User {
	private DbHelper dbHelper = null;
	
	public User(DbHelper dbH) {
		dbHelper = dbH;
	}
	
	public boolean StoreData(String name, int age) {
		boolean bResult = true;

		if (dbHelper.IsUserExists(name)) {
			if (age == dbHelper.GetAge()) {
				// Data in DB matches input data, no action needed.
			} else {
				dbHelper.SetAge(age);
			}
		} else {
			dbHelper.SetUserName(name);
			dbHelper.SetAge(age);
			if (!dbHelper.IsUserExists(name)) {
				bResult = false;
			}
		}

		return bResult;
	}
}

package rameshNotes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

@RunWith(Suite.class)
@SuiteClasses({ UserTest.class,
				DbHelperTest.class })
class AllTests {

}

public class TestRunner {
	
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(AllTests.class);
		
		System.out.println("Total Test Cases Executed: " + result.getRunCount() + ", Failed: " + result.getFailureCount() + ", Time Taken: " + result.getRunTime() + "ms");
		System.out.println("Failed Test Cases Details:\n");

		int i =1;
		for (Failure failure : result.getFailures()) {
			System.out.println(i + ": " + failure.toString());
			i++;
		}
	}

}

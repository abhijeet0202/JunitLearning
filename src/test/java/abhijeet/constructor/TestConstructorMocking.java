package abhijeet.constructor;
import static org.junit.Assert.assertNull;
import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;

import org.junit.Test;



public class TestConstructorMocking {
	 
	
	@Test
	public void TC1_Mock_DefaultConstructor() {
		new MockUp<Student>() {
			@Mock 
			public void $init() {
				
			}
	   };	   
	  Student p = new Student();
	  String name = p.getName();
	   
	  assertNull("Hi",name);
	 }	
	
	@Test
	public void TC2_Mock_ParametraizedConstructor() {
		new MockUp<Student>(){
			@Mock public void $init(String name){
				//Dont assign name variable at all
				//Leave it null
			}
		};
		Student obj = new Student("Hello");
		String name = obj.getName();
		
		assertNull("Hello",name);
	}

	
	/*
	 * Case1 : when Single Constructor line written inside Code under test
	 * 
	 * Declare a single mock field or mock parameter of the desired class, using @Mocked.
	 * This mock field/parameter,is not used when recording expectations;
	 * instead, its use the object on instantiation recordings to record on actual method call.
	 * In Short,This is the syntax to mock future instances(constructor) that will later get 
	 * created by code under test
	 */
	@Test
	public void TC3_Mock_MarksConstructor(@Mocked Marks mockMarks) {
		new Expectations(){{
				Marks m = new Marks(anyInt);
				m.setMarks(anyInt);
				//Dont assign name variable at all
				//Leave it null
			}
		};
		Student obj = new Student("Hello");
		obj.setName("hello");
		
		//assertNull("Hello",name);
	}
	
	/*
	 * Case2 : when multiple Constructor with different parameters line written inside Code under test
	 * 
	 * Declare a single mock field or mock parameter of the desired class, using @Mocked.
	 * This mock field/parameter,is not used when recording expectations;
	 * instead, its use the object on instantiation recordings to record on actual method call.
	 * In Short,This is the syntax to mock future instances(constructor) that will later get 
	 * created by code under test
	 */
	@Test
	public void TC4_Mock_MarksConstructorMultiple(
			@Mocked Marks mockMarks1,
			@Mocked Marks mockMarks2,
			@Mocked Marks mockMarks3) {
		new Expectations(){{
				new Marks(anyInt); result =mockMarks1;
				new Marks(anyString); result =mockMarks2;
				new Marks(anyDouble); result = mockMarks3;
				mockMarks1.setMarks(anyInt);
				//Dont assign name variable at all
				//Leave it null
			}
		};
		Student obj = new Student("Hello");
		obj.setNameMultiple("hello");
		
		//assertNull("Hello",name);
	}
}

package abhijeet.staticBlock;
import static org.junit.Assert.assertEquals;
import mockit.Mock;
import mockit.MockUp;

import org.junit.Test;

public class TestStaticBlocks {

	@Test
	public void testBankStaticBlock(){
		new MockUp<MyBank>(){
			@Mock public void $clinit(){
				MyBank.updateBalance(500);
			}
		};
		assertEquals("The balance amount is 500", 500, MyBank.amount);
		System.out.println(MyBank.amount);
	}
}

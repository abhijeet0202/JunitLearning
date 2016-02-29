package abhijeet.countConstraint;

import mockit.Expectations;
import mockit.Mocked;

import org.junit.Test;

public class TestcountConstraint {

@Mocked Counter cc;
	@Test
	public void TC1_getCountConstraint() {
				
			new Expectations() {{
/*
 * times: A non-negative value assigned to this field will be taken as the exact number
 * of times that invocations matching the current expectation should occur during replay.
 *
 * minTimes: A non-negative value assigned to this field will be taken as the minimum 
 * number of times that invocations matching the current expectation should occur 
 * during replay. Zero or a negative value implies there is no lower limit. 
 * The maximum number of times is automatically adjusted to allow any number of invocations.
 * 
 * maxTimes: A non-negative value assigned to this field will be taken as the maximum 
 * number of times that invocations matching the current expectation should occur 
 * during replay. A negative value implies there is no upper limit.
 * 
 * Both minTimes and maxTimes can be specified for the same expectation, 
 * as long as minTimes is assigned first.(if maxTime specify first it will be ignored)
 */

				cc.setCount(); maxTimes =3;minTimes=1;times=4;
				cc.setCounter(anyInt); minTimes=1;maxTimes =5;times=4;
			}
			};
		
		CountConstraint my = new CountConstraint();
		my.getCount();
	}

}

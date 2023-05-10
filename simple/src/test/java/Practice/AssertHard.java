package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertHard {
	@Test
	public void m1() {
		System.out.println("step1");
		System.out.println("step2");
		Assert.assertEquals(true, true);
		System.out.println("step3");
		System.out.println("step4");
	}
	@Test
	public void m2()
	{
		String exp="shobharani";
		String act="shobharani";
		Assert.assertEquals(act,exp);
	}

}

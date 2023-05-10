package Practice;

import org.testng.annotations.Test;

public class SoftAssert {
	@Test
	public void m1()
	{
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
	org.testng.asserts.SoftAssert soft=new org.testng.asserts.SoftAssert();
		soft.assertEquals(true,false);
		System.out.println("step4");
		System.out.println("step5");
		soft.assertAll();
	}

}

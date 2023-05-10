package Practice;

import org.testng.annotations.Test;

public class DataProvider {
	@Test(dataProvider="dataProviderMethod")
	public void bookTickets(String src,String des)
	{
		System.out.println("Book tickets from"+src+"to"+des);
	}
	@org.testng.annotations.DataProvider
	public Object[][]dataProviderMethod(){
		Object[][] obj=new Object[3][2];
		obj[0][0]="Banglore";
		obj[0][1]="goa";
		
		obj[1][0]="Banglore";
		obj[1][1]="mysuru";
		
		obj[2][0]="Banglore";
		obj[2][1]="Hyd";
		return obj;
		
		
	}
	

}

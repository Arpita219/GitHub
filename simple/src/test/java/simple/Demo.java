package simple;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Demo {

	public static void main(String[] args) {
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.google.com");
		//Screen s=new Screen();
		//Pattern img=new Pattern("");
		//s.click(img);
	}

}

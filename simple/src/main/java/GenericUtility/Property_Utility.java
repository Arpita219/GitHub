package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Property_Utility {
	
	public  String getStringKeyAndValue(String key) throws Throwable  {
		FileInputStream fis=new FileInputStream("./src/test/resources/PropertyFileData.properties");
        Properties pro=new Properties();
        pro.load(fis);
        String Value = pro.getProperty(key);
		return Value;
        
	
	}

}

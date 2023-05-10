package simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Browser {

	public static void main(String[] args) throws Throwable {
		
	//step1:Register driver	
     Driver driverRef=new Driver();
     DriverManager.registerDriver(driverRef);
     
     //step2:connection to database
     Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
     
     //step3:create sql statement
     Statement stat=conn.createStatement();
     String query="select*from student";
     
     //step4:Execute Query
     ResultSet result = stat.executeQuery(query);
     while(result.next())
     {
    	System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)); 
     }
     
     //step5:close database commection
     conn.close();
	}

}

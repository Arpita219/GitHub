package simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertData {

	public static void main(String[] args) throws Throwable {
		//step1:Register driver	
	     Driver driverRef=new Driver();
	     DriverManager.registerDriver(driverRef);
	     
	     //step2:connection to database
	     Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
	     
	     //step3:create sql statement
	     Statement stat = conn.createStatement();
	     String query="insert into student(first_name,last_name)values('qspider','qspider')";
	     
	     int result = stat.executeUpdate(query);
	     
	     /*if(result==1)
	     {
	    	 
	     }*/
	}

}

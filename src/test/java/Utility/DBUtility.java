package Utility;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtility {

		private final static String username = ConfigurationReader.getProperty("JDBC_Username"),
					 				password = ConfigurationReader.getProperty("JDBC_Password"),
					 				url = ConfigurationReader.getProperty("JDBC_URL");
	
		private static Connection connection;
		private static Statement statement;
		public static DatabaseMetaData metaData;

		static {
			try {
				connection = DriverManager.getConnection(url, username, password);				
				statement = connection.createStatement();
				metaData=connection.getMetaData();
			}catch(Exception e) {
				System.err.println("Cannot connected to DataBase...");
			}
		}
		
		public static ResultSet getResult(String query) {
			ResultSet result=null;
			try {
			result = statement.executeQuery(query);
			}catch(Exception e2) {
				System.err.println("Cannot get the data...");
			}
			return result;
		}
		
		public static void tearDown() {
			try {
				connection.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}

	
}

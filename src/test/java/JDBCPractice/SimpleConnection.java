package JDBCPractice;

import java.sql.*;

public class SimpleConnection {
    public static void main(String[] args) throws SQLException {
        String url="jdbc:oracle:thin:@3.83.130.195:1521:xe";
        String username="hr";
        String password="hr";
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement=connection.createStatement();
        ResultSet result=statement.executeQuery("select * from countries");
        while (result.next()){
            String countryName=result.getString("country_name");
            if (countryName.equalsIgnoreCase("germany"))
            System.out.println(countryName);
        }

    }
}
/*
Methods:
• next()
• getString(ColumName)
• getString(Index)
• getInt(ColumName)
• getInt(Index)
• getDouble(ColumName)
• getDouble(Index)
• getDate(ColumName)
• getDate(Index)
*/
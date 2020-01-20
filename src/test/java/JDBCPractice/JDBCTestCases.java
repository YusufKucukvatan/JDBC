package JDBCPractice;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.*;

public class JDBCTestCases {


    public JDBCTestCases() throws SQLException {
    }

    Connection connection;
    Statement statement;

    @BeforeMethod
    public void setUp() throws SQLException {
        String url = "jdbc:oracle:thin:@3.83.130.195:1521:xe";
        String username = "hr";
        String password = "hr";
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();
    }

    @Test(description = "Verify if Kochhar's salary is greater than Hunold's salary")
    public void Test1() throws SQLException {
        ResultSet result=statement.executeQuery("select * from employees");
        int salaryKochhar = 0;
        int salaryHunold = 0;
        while(result.next()) {
            if (result.getString("last_name").equalsIgnoreCase("kochhar")) {
                salaryKochhar = result.getInt("salary");
                System.out.println(salaryKochhar);
            }
            if (result.getString("last_name").equalsIgnoreCase("hunold")) {
                salaryHunold = result.getInt("salary");
                System.out.println(salaryHunold);
            }
        }
        Assert.assertTrue(salaryKochhar > salaryHunold);
    }

}


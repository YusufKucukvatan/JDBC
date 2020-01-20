package JDBCPractice;

import Utility.DBUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestCaseUtility {
    @Test(description = "Verify that Steven King has the greatest salary in employees table")
    public void test1() throws SQLException {
        ResultSet result = DBUtility.getResult("select * from employees");
        int maxSalary=0;
        String actualName="";
        String expectedName="Steven King";
        while(result.next()){
            if(result.getInt("salary")>maxSalary){
                maxSalary=result.getInt("salary");
                actualName=result.getString("first_name")+" "+result.getString("last_name");
            }
        }
        Assert.assertEquals(expectedName,actualName,"Steven King does not have greatest salary...");
    }
}

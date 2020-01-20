package JDBCPractice;

import Utility.DBUtility;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;

public class MetaData {
    public static void main(String[] args) throws SQLException, SQLException {

        System.out.println("User: "+DBUtility.metaData.getUserName());
        System.out.println("Driver version: "+DBUtility.metaData.getDriverVersion());
        System.out.println("Driver name: "+DBUtility.metaData.getDriverName());
        System.out.println("Max username length: "+DBUtility.metaData.getMaxUserNameLength());
        System.out.println("Product version: "+DBUtility.metaData.getDatabaseProductVersion());
        System.out.println("Product name: "+DBUtility.metaData.getDatabaseProductName());

        ResultSet rs = DBUtility.getResult("select * from employees");
        ResultSetMetaData resultData = rs.getMetaData();
        System.out.println(resultData.getColumnCount());
        System.out.println(resultData.getColumnName(2));
        System.out.println(resultData.getColumnName(5));

        String[] columnNames=new String[resultData.getColumnCount()];
        for (int i = 0; i < columnNames.length; i++) {
            columnNames[i]=resultData.getColumnName(i+1);
        }
        System.out.println(Arrays.toString(columnNames));
    }
}

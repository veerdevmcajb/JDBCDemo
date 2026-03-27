package com.employee;

import java.sql.*;
import java.util.Scanner;

/*  Develop JDBC application to increase employees salary based on Department.
    Read Hike Percentage for Each Deparment from Keyboard and then update salary with given percentage.
    Formula :   New_Salary = existing_sal + (existing_Sal * hike_percentage) / 100;
*
* */

public class EmployeeSalBasedOnDept {
    private static final String url ="jdbc:mysql://localhost:3306/advjdbc";
    private static final String userName = "root";
    private static final String pass = "root12";
    private static final String Select_Query ="select * from employee";

    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner (System.in);
        System.out.println("Enter Dept Name");
        String dept = sc.next();

        System.out.println("Enter Emp Hike :: ");
        double hike = sc.nextDouble();

        StringBuilder Update_Query = new StringBuilder( "update employee set EMP_SALARY = EMP_SALARY + (EMP_SALARY * ?) / 100  where 1=1" );

        if(dept!=null && !dept.equals("null")){
            Update_Query.append(" AND EMP_DEPT= ?");
        }


        Connection con = DriverManager.getConnection(url,userName,pass);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(Select_Query);
        PreparedStatement pstmt = con.prepareStatement(Update_Query.toString());
//        int index = 1;
//
//        if(dept!=null && !dept.equals("null")){
//            pstmt.setString(index, dept);
//            index ++;
//        }
//
//        pstmt.setDouble(1,hike);

        int index = 1;

        pstmt.setDouble(index, hike);
        index++;

        if(dept!=null && !dept.equals("null")){
            pstmt.setString(index, dept);
        }

        pstmt.executeUpdate();
        System.out.println("Update Completed...");
        con.close();


    }
}

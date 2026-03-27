package com.employee;

import java.sql.*;
import java.util.Scanner;

// * This one is Recommanded ...

public class EmpHike_RightWay {

    private static final String url ="jdbc:mysql://localhost:3306/advjdbc";
    private static final String userName = "root";
    private static final String pass = "root12";
    private static final String Select_Query ="select * from employee";

    public static void main(String[] args) throws Exception{

        Scanner sc =new Scanner(System.in);
        System.out.println("Enter Emp Hike :: ");
        double hike = sc.nextDouble();

        String Update_Query = "update employee set EMP_SALARY=EMP_SALARY + (EMP_SALARY * ?) / 100 ";

     Connection con = DriverManager.getConnection(url,userName,pass);
     Statement stmt = con.createStatement();
     ResultSet rs = stmt.executeQuery(Select_Query);
     PreparedStatement pstmt = con.prepareStatement(Update_Query);
     pstmt.setDouble(1,hike);

     pstmt.executeUpdate();
        System.out.println("Update Completed...");
        con.close();
    }
}

package com.employee;

import com.sun.tools.javac.Main;

import java.sql.*;
import java.util.Scanner;

public class EmpHike {

    private static final String url = "jdbc:mysql://localhost:3306/advjdbc";
    private static final String username = "root";
    private static final String pass ="root12";
    private static final String Select_Sql = "select * from employee";
    private static final String Update_Sal_Sql = "update employee set EMP_SALARY = ? where EMP_ID = ?";

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee Hike :: ");
        double hike=sc.nextDouble();

       Connection con = DriverManager.getConnection(url,username,pass);
       Statement stmt  = con.createStatement();
       ResultSet rs = stmt.executeQuery(Select_Sql);

      PreparedStatement pstmt = con.prepareStatement(Update_Sal_Sql);

      while (rs.next()){
          int empId = rs.getInt("EMP_ID");
          double existingSal = rs.getDouble("EMP_SALARY");
          double newSal = existingSal + (existingSal * hike)/100;
          pstmt.setDouble(1,newSal);
          pstmt.setInt(2,empId);
          pstmt.executeUpdate();
      }
        System.out.println("Update completed....");
        con.close();

    }
}

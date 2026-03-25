package com.employee;

import java.sql.*;
import java.util.Scanner;

public class Employee {

    private static final String url = "jdbc:mysql://localhost:3306/advjdbc";
    private static final String username = "root";
    private static final String pass = "root12";

    public static void main(String[] args)throws Exception {
       // insertData();
        display();
    }

    public static void insertData() throws Exception {

        String Query = "insert into employee values (?,?,?,?,?,?)";

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee Id");
        int id = sc.nextInt();

        System.out.println("Enter Employee Name");
        String name = sc.next();

        System.out.println("Enter Employee Salary");
        double salary = sc.nextDouble();

        System.out.println("Enter Employee Department");
        String dept = sc.next();

        System.out.println("Enter Employee gender");
        String gender = sc.next();

        System.out.println("Enter Employee Work Location");
        String workLoc = sc.next();

       Connection con = DriverManager.getConnection(url,username,pass);
       PreparedStatement pstmt = con.prepareStatement(Query);
        pstmt.setInt(1,id);
        pstmt.setString(2,name);
        pstmt.setDouble(3,salary);
        pstmt.setString(4,dept);
        pstmt.setString(5,gender);
        pstmt.setString(6,workLoc);

       int count  = pstmt.executeUpdate();
        System.out.println("Row Effected.." + count);

    }

    public static void display() throws Exception{

      Connection con = DriverManager.getConnection(url,username,pass);
      Statement stmt = con.createStatement();
      ResultSet rs  = stmt.executeQuery("select * from EMPLOYEE");
      while (rs.next()){
          System.out.println(rs.getInt(1) + "\t " +rs.getString(2) + "\t "+ rs.getDouble(3) + "\t "+
                  rs.getString(4) + "\t " + rs.getString(5) + " \t" + rs.getString(6));
      }
    }


}

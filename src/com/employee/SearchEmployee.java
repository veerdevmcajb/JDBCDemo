package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SearchEmployee {
    private static final String url = "jdbc:mysql://localhost:3306/advjdbc";
    private static final String username = "root";
    private static final String pass = "root12";

    public static void main(String[] args)  throws Exception{

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee dept");
        String dept = sc.next();

        System.out.println("Enter Employee Location :: ");
        String workLocation  = sc.next();

        System.out.println("Enter Employee Gender :: ");
        String gender = sc.next();

        StringBuilder sql = new StringBuilder("select * from EMPLOYEE where 1=1");

        if(dept!=null && !dept.equals("null")){
            sql.append(" AND EMP_DEPT= ?");
        }

        if(workLocation !=null && !workLocation.equals("null")){
            sql.append("AND WORK_LOCATION = ?");
        }
        if(gender !=null && !gender.equals("null")){
            sql.append("AND EMP_GENDER = ?");
        }

        Connection con = DriverManager.getConnection(url,username,pass);
       PreparedStatement pstmt  = con.prepareStatement(sql.toString());

        int index = 1;

        if(dept!=null && !dept.equals("null")){
            pstmt.setString(index, dept);
            index ++;
        }

        if(workLocation !=null && !workLocation.equals("null")){
            pstmt.setString(index,workLocation);
            index++;
        }

        if(gender !=null && !gender.equals("null")){
            pstmt.setString(index,gender);
            index ++;
        }

      ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            System.out.println(rs.getInt(1) + "\t " +rs.getString(2) + "\t "+ rs.getDouble(3) + "\t "+
                    rs.getString(4) + "\t " + rs.getString(5) + " \t" + rs.getString(6));
        }

        con.close();
    }
}


// The above requirement is dynamic search we need to prepare the query based on user given inputs.
//
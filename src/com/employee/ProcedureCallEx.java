package com.employee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.concurrent.Callable;

public class ProcedureCallEx {

    private static final String url = "jdbc:mysql://localhost:/advjdbc";
    private static final String username = "root";
    private static final String pass = "root12";
    private static final String procedure = " call getBooksData()";

    public static void main(String[] args)  throws Exception{

        Connection con = DriverManager.getConnection(url,username,pass);
        CallableStatement cstmt = con.prepareCall(procedure);
        ResultSet rs  = cstmt.executeQuery();

        while (rs.next()){
            System.out.println(rs.getInt(1) +" " + rs.getString(2) +" " + rs.getDouble(3));
        }

        con.close();
    }
}

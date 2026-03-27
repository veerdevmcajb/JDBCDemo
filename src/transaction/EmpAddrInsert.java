package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class EmpAddrInsert {

    private static final String url = "jdbc:mysql://localhost:3306/advjdbc";
    private static final String userName = "root";
    private static final String pass = "root12";

    private static final String emp_insert = "insert into emp values (?,?,?)";
    private static final String emp_address_insert = "insert into emp_address values(?,?,?,?)";

    public static void main(String[] args) throws Exception{

     Connection con =  DriverManager.getConnection(url,userName,pass);
    con.setAutoCommit(false);

    try {
       PreparedStatement pstmt = con.prepareStatement(emp_insert);
        pstmt.setInt(1,101);
        pstmt.setString(2,"john");
        pstmt.setDouble(3,1000);

        pstmt.executeUpdate();

       pstmt = con.prepareStatement(emp_address_insert);
        pstmt.setString(1,"Hyd");
        pstmt.setString(2,"TG");
        pstmt.setString(3,"India");
        pstmt.setInt(4,101);

        pstmt.executeUpdate();

        con.commit();

        System.out.println("Record Inserted");

    }catch (Exception e){
        System.out.println("Transcation Rolled Back...");
        con.rollback();
    }

    con.close();

    }
}

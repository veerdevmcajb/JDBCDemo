package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectEmpWithAddr {
    private static final String url = "jdbc:mysql://localhost:3306/advjdbc";
    private static final String userName = "root";
    private static final String pass = "root12";

    private static final String emp_select = "select * from emp e, emp_address a where e.emp_id = a.emp_id and e.emp_id = ?";

    public static void main(String[] args) throws Exception {

       Connection con  = DriverManager.getConnection(url,userName,pass);

       PreparedStatement pstmt = con.prepareStatement(emp_select);

       pstmt.setInt(1,101);

      ResultSet rs = pstmt.executeQuery();

     while (rs.next()){
         System.out.println(rs.getInt(1));
         System.out.println(rs.getString(2));
         System.out.println(rs.getDouble(3));
         System.out.println(rs.getString(4));
         System.out.println(rs.getString(5));
         System.out.println(rs.getString(6));
     }

     con.close();

    }
}

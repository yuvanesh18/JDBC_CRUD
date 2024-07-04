/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package yuvi.crud_jdbc;
import java.sql.*;

/**
 *
 * @author Yuvanesh
 */
public class CRUD_JDBC {

    public static void main(String[] args) throws SQLException {
        Crud_operation c = new Crud_operation();
        c.connect();
    }
}

class Crud_operation{
    Connection con = null;
    
    public void connect() throws SQLException
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CRUD", "root", "123qwe!@#QWE");
        } catch (ClassNotFoundException ex) {
           System.out.print(ex);
        }
       
    }
}
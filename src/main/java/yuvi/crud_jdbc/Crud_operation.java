/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yuvi.crud_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Yuvanesh
 */
public class Crud_operation {
    
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
    
    //add student details
    public void addstudent(int id,String fn,String ln,String mail,String city)
    {
        String query = "Insert into student_list values(?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1,id);
            ps.setString(2, fn);
            ps.setString(3, ln);
            ps.setString(4, mail);
            ps.setString(5, city);
            ps.executeUpdate();
        } catch (SQLException ex) {
          System.out.print(ex);
        }
    }
    
    // remove student data
    public void removestudent(int id) throws SQLException
    {
        String query ="delete from student_list where PersonID=?";
        PreparedStatement ps=null;
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException ex) {
           System.out.print(ex);
        }
    }
  
//  getstudent details
      public void getstudent(int id) throws SQLException
    {
        String query ="select * from student_list where PersonID=?";
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1,id);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
           System.out.print(ex);
        }
        if(rs.next())
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+
                                rs.getString(4)+" "+rs.getString(5));
    }
      
    //displace student details
    public void display() throws SQLException
    {
        String query ="select * from student_list";
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException ex) {
            System.out.print(ex);
        }
          
        while(rs.next())
        {
           System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+
                   rs.getString(4)+" "+rs.getString(5)); 
        }
        st.close();
        rs.close();
    }
    
}


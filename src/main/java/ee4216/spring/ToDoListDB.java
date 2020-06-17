/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee4216.spring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTransactionRollbackException;
import java.sql.Statement;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/**
 *
 * @author yatha
 */
@Component
public class ToDoListDB {
      @PostConstruct
    public void initDB() throws SQLException
    {
        Connection con = null;
    Statement st = null;
        ResultSet rs = null;
      

         //adding create=true (create db if not exist);
        String url = "jdbc:derby://localhost:1527/to-do;create=true";
        String user = "test";
        String password = "test";

        // create table 
        String sql1 = "CREATE TABLE todos (\n"
                + "CONTENT VARCHAR(256) DEFAULT NULL, \n"
                + "DONE BOOLEAN DEFAULT NULL \n"
                + ")";
        
        // insert records
      
          con = DriverManager.getConnection(url, user, password);
        st = con.createStatement();
        
         try {
            st.executeUpdate(sql1);
           
        } catch (SQLTransactionRollbackException e) {
            System.out.println("*** todos table already exists");
        }
    }
    public void addDB(String s,Boolean b) throws SQLException
    {
        
        Connection con = null;
    Statement st = null;
        ResultSet rs = null;
      

         //adding create=true (create db if not exist);
        String url = "jdbc:derby://localhost:1527/to-do;create=true";
        String user = "test";
        String password = "test";

        
        
        // insert records
        String sql2 = "INSERT INTO todos VALUES\n"
                + "("+"'"+s+"',"+ b +")" ;
                
        
          con = DriverManager.getConnection(url, user, password);
        st = con.createStatement();
        
         try {
         
             st.executeUpdate(sql2);
            
        } catch (SQLTransactionRollbackException e) {
            System.out.println("*** todos table already exists");
        }
        
    }
    
    public void updateDB() throws SQLException
    {
         Connection con = null;
    Statement st = null;
        ResultSet rs = null;
      

         //adding create=true (create db if not exist);
        String url = "jdbc:derby://localhost:1527/to-do;create=true";
        String user = "test";
        String password = "test";

        
        
        // insert records
        String sql2 = "Update todos\n"
                + "SET DONE=true\n"
                +"Where DONE=false";
                
    
        
          con = DriverManager.getConnection(url, user, password);
        st = con.createStatement();
        
         try {
         
             st.executeUpdate(sql2);
            
        } catch (SQLTransactionRollbackException e) {
            System.out.println("*** todos table already exists");
        }
    }
}

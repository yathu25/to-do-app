/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee4216.spring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLTransactionRollbackException;
import java.sql.Statement;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

/**
 *
 * @author yatha
 */
@Component
public class ToDoRepo {
    public ArrayList<ToDo> getAllToDos(){
        ArrayList<ToDo> heads = new ArrayList<ToDo>();


    try {
       
        Connection con = null;
        //Statement st = null;
        String url = "jdbc:derby://localhost:1527/to-do";
        String user = "test";
        String password = "test";
        con = DriverManager.getConnection(url, user, password);

        
   

        PreparedStatement pstmt = con.prepareStatement("select * from todos");
       ResultSet rs = pstmt.executeQuery(); 
          
        while(rs.next()){    
          ToDo head = new ToDo();
            head.setTitle(rs.getString(1));
            head.setDone(rs.getBoolean(2));
            
            
           
            

            heads.add(head);
        } 
        return heads;
       
    }
      catch (Exception e2) {return null;} 
    }
}
   
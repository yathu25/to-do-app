/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee4216.spring;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTransactionRollbackException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author yatharth
 */
@CrossOrigin
@RestController
@RequestMapping(path="/api")                // base URL for all handlers
public class RestfulController {
      @Autowired private ToDoRepo todoss;
      @Autowired private ToDoListDB db;
   
     @GetMapping(path="/toDo", produces="application/json")                // map to /api/status
    public ArrayList<ToDo> getTodo() throws JsonProcessingException, SQLException {
      
         
         return todoss.getAllToDos();
       
    }
 
    
     
    @PostMapping(value = "/toDo", consumes = "application/json")
    public String createToDo(@RequestBody ToDo toDo) throws SQLException {
        db.addDB(toDo.getTitle(),toDo.getDone());
        
         return "Successful";
    }
    
    
    
     @PostMapping(value = "/toDo/updateMultiple", consumes = "application/json")
    public String updateMultiple(@RequestBody List<ToDo> toDo) throws SQLException {
        
           db.updateDB();
         return "Successful";
    }
    
    
    
    
    
    
    
    
    @PostMapping(value = "/toDo/delete", consumes = "application/json")
    public String deleteToDo(@RequestBody List<ToDo> toDo) {
        
         System.out.println(toDo.get(0).getTitle());
         return "Successful";
    }
    
    
    
    
     @PostMapping(value = "/toDo/update", consumes = "application/json")
    public String updateToDo(@RequestBody List<ToDo> toDo) {
        
         System.out.println(toDo.get(0).getTitle());
         return "Successful";
    }
//  @PostMapping("/toDO")
//  public void greetingSubmit(@ModelAttribute To_do to_do) {
//    System.out.println(to_do);
//    
//  }
//    
//   

    

}

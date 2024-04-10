package seekopjc.demo.controllers;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import seekopjc.demo.config.DBCon;

@RestController
@RequestMapping(value = "/test")
public class TestController {
    
    @GetMapping()
    public LinkedList<HashMap<String, Object>> index(HttpServletRequest request){
        try {
           
        
 
        Connection connection = DBCon.connection();
            

        String sql = "Create table students (ID int primary key, name varchar(50))";
         
        
        Statement statement = connection.createStatement();

        statement.execute(sql);
        
         
        System.out.println("Created table students.");

        sql = "Insert into students (ID, name) values (1, 'Nam Ha Minh')";

        statement.executeUpdate(sql);

        ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
        
        while (resultSet.next()) {
            int id=resultSet.getInt("ID");
            String name = resultSet.getString("name");
            System.out.println("ID: " + id + ", Name: " + name);
        }

        
        connection.close();
         
        
        
         LinkedList<HashMap<String,Object>> results=new LinkedList<>();     
            HashMap<String,Object> row=new HashMap<>(); 
            row.put("test", "test");
            results.add(row);
            return results;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        
    }
}

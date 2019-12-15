/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JudgingSystem;
import java.sql.*; 

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

/**
 *
 * @author acer
 */
public class Javaconnect {
    
    
    Connection conn =null;

	 
	 public static Connection dbConnection() {
		 
		 try{
			 
			 Class.forName("com.mysql.jdbc.Driver");
			 
			 
			 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","") ;
			 
			//JOptionPane.showMessageDialog(null,"Connection Successfully");
			 return conn;
					 
		 }catch(Exception e){
			 
			 
			 JOptionPane.showMessageDialog(null,e);
			 return null;
			 
		 }
		 
		 
		 
		 
		 
	 }
	
    
    
    
    
    
}

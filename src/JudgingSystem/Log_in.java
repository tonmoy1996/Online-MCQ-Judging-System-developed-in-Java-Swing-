/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JudgingSystem;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.*;
import java.awt.*;

public class Log_in extends  JFrame{
    
    private JButton Register;
    private JTextField email;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton4;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JTextField name;
    public static JPasswordField passwordField;
    private JPasswordField passwordFieldreg;
    public static JTextField username;
    
    
    
    
     ResultSet rs=null;
    PreparedStatement pst= null;
    Connection conn =null;

    public Log_in() {
       initComponents(); 
         conn=Javaconnect.dbConnection();
        
        
    }
    
      public void close(){
    
    WindowEvent WinClosingEventeEvent=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
    
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(WinClosingEventeEvent);
    
    
    }
    
   private void initComponents() {
       
      //variable allocation
       
       
        jLabel1 = new JLabel();
        username = new JTextField();
        jLabel2 = new JLabel();
        passwordField = new JPasswordField();
        jButton1 = new  JButton();
        jButton2 = new JButton();
        name = new JTextField();
        passwordFieldreg = new JPasswordField();
        email = new JTextField();
        Register = new JButton();
        jLabel3 = new  JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jButton4 = new JButton();
        jLabel7 = new JLabel("Q2A");
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        
        
  //jalbel q2a
    jLabel7.setBounds(190, 10, 220, 30);
    jLabel7.setFont(new java.awt.Font("Vivaldi", 1, 36)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(255, 255, 0));
    
 //jLabel8
    
     jLabel8.setBounds(280, 30, 100, 30);
     jLabel8.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 14)); // NOI18N

     jLabel8.setForeground(new java.awt.Color(255, 0, 0));

     jLabel8.setText("Judging System");



 //
   
    jLabel3.setBounds(40, 90, 70, 50);
   //jLabel3.setForeground(new java.awt.Color(255, 255, 255));

  jLabel3.setText("Enter Name:");

   
  //nametextField
   name.setBounds(20, 130, 110, 20);
   
  //passwordField
   jLabel4.setBounds(32, 150, 100, 20);
   jLabel4.setText("New Password:");

//
   passwordFieldreg.setBounds(20, 170, 110, 20);
  //email jlabel field   
    jLabel5.setBounds(32, 190, 90, 20);
    
   jLabel5.setText("Enter Email :");

//mail testfield
   
   email.setBounds(20,210,110,20);
   
   //register button
   
   
   
   Register.setBounds(20, 270,100,20);
   Register.setText("Register");
   
  

Register.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        RegisterActionPerformed(evt);
    }
});

//username

jLabel1.setBounds(340, 130, 76, 22);

jLabel1.setText("Username:");
//usernameTextfield

username.setBounds(430, 130, 138, 30);

//password label
jLabel2.setBounds(340, 170, 90, 22);
jLabel2.setText("Password:");

//password field

passwordField.setBounds(430, 170, 138, 30);
//user login button

jButton1.setBounds(440, 210, 120, 20);
jButton1.setText("User Login");

jButton1.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
      userloginActionPerformed(evt);
    }
});

//Admin button 

jButton2.setBounds(440, 240, 120, 20);
jButton2.setText("Admin Login");

//jButton2.setToolTipText("");

jButton2.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
       AdminloginActionPerformed(evt);
    }
});



   
 //add component to Frame
  this.setLayout(null);
  this.add(jLabel7);
  this.add(jLabel8);
  this.add( jLabel3);
  this.add(name);
  this.add(jLabel4);
  this.add(passwordFieldreg);
 
  this.add(jLabel5);
  this.add(email);
  this.add( Register);
  this.add(jLabel1);
  this.add(username);
  this.add(jLabel2);
  this.add(passwordField);
  this.add(jButton1);
    this.add(jButton2);
  //frame   
        
        
  
  this.setSize(600,400);
  this.setTitle("Login");
  this.setVisible(true);
    
 
  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       
       

     
    }                     
 //end component 
    
    
    
 //register acction performed
private void   RegisterActionPerformed(java.awt.event.ActionEvent evt) { 
    
     	
				
				int insert=JOptionPane.showConfirmDialog(null,"Do you want to Insert ?","INSERT",JOptionPane.YES_NO_OPTION );
				if(insert==0){
				
				try{
                                    
                                    String query=" select *from employ where username=? ";
					
                                                pst= conn.prepareStatement(query);
					pst.setString(1, name.getText());
					
					
					
                                                rs=pst.executeQuery();
                                        
                                       
					 if(rs.next()){
					 //JOptionPane.showMessageDialog(null,"Successfully Login");	
                                            rs.close();
                                             pst.close();
                                      //     close();
						
                                           
                                                  Profile n1=new Profile();
                                                
                                                    n1.setVisible(true);
                                               
                                                  
							
						 
					 }
					 else{
						 
						
					
					String sql = "INSERT INTO employ (username, Password , email) VALUES (?,?,?)";
					
					PreparedStatement statement = conn.prepareStatement(sql);
					
					statement.setString(1,name.getText());
					statement.setString(2,passwordFieldreg.getText());
					statement.setString(3,email.getText());
					
					statement.execute();
					
					JOptionPane.showMessageDialog(null,"Save data successfully");
					
					statement.close();
					
					
				
					name.setText(null);
					passwordFieldreg.setText(null);
					email.setText(null); 
						 
						 
					 }
                                    
                                    
                          	
					
				}catch(Exception e2){
					
					//e2.printStackTrace();
					
				}

				
				
				
				
				
				
				}
    
    
    
    
    }
    
 //user login button

private void   userloginActionPerformed(java.awt.event.ActionEvent evt) { 

  try{
					
					String query=" select *from employ where username=? and password=?";
					//PreparedStatement 
                                                pst= conn.prepareStatement(query);
					pst.setString(1, username.getText());
					pst.setString(2, passwordField.getText());
					
					
                                                rs=pst.executeQuery();
                                        
                                       
					 if(rs.next()){
					// JOptionPane.showMessageDialog(null,"Successfully Login");	
                                            rs.close();
                                             pst.close();
                                          //  close();
						

                                            
                                                 Profile n=new Profile();
                                                Profile.L1.setText(this.username.getText());
                                                 n.setVisible(true);
                                                 this.setVisible(false);
                                                 
                                                  
							
						 
					 }
					 else{
						 
						 JOptionPane.showMessageDialog(null,"Incorrect Password");
						 
						 
					 }
					
				}catch (Exception e1){
					
					JOptionPane.showMessageDialog(null,e1);
					
				}
				
        







}
    

//Admin Login

private void   AdminloginActionPerformed(java.awt.event.ActionEvent evt) { 

    try{
					
					String query=" select *from admin where username=? and password=?";
					//PreparedStatement 
                                                pst= conn.prepareStatement(query);
					pst.setString(1, username.getText());
					pst.setString(2, passwordField.getText());
					
					
                                                rs=pst.executeQuery();
                                        
                                       
					 if(rs.next()){
					 JOptionPane.showMessageDialog(null,"Successfully Login");	
                                            rs.close();
                                             pst.close();
                                          //  close();
						
                                               
                                                //  NewJFrame1 n=new NewJFrame1();
        
                                                  //NewJFrame1.L1.setText(this.username.getText());
                                            
                                              Admin n=new Admin();
                                                Admin.L11.setText(this.username.getText());
                                                n.setVisible(true);
                                                this.setVisible(false);
                                                 
                                                  
							
						 
					 }
					 else{
						 
						 JOptionPane.showMessageDialog(null,"Incorrect Password");
						 
						 
					 }
					
				}catch (Exception e3){
					
					JOptionPane.showMessageDialog(null,e3);
					
				}
				
        
        
        







}
    
    
    

    
    
    
    
    
    
}

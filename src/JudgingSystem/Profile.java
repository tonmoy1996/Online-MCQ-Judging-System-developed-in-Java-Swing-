/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JudgingSystem;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author acer
 */
public class Profile extends JFrame{
     
    //variable 
     public static JLabel L1;
    private JTextField email;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel7;
    private JTextField name;
    private JTextField password;
     
    Connection conn =null;

    public Profile() {
       intcomponent();
        conn=Javaconnect.dbConnection();
         Refresh();
    }
    
   
    
    public void Refresh(){
		try{
		String sql = "SELECT *from employ where username='"+L1.getText()+"'";          //+id+ means variable
					PreparedStatement statement = conn.prepareStatement(sql);
				     
					
					
					
					
					ResultSet result = statement.executeQuery();
					
					
					
					while(result.next()){
					
						
						//Id.setText(result.getString("id"));
                                                password.setText(result.getString("password"));
						name.setText(result.getString("username"));
						email.setText(result.getString("email"));
						
						
					}
					
				
					
					statement.close();
					
					
					
					
					
					
				}catch(Exception e2){
					
					e2.printStackTrace();
					
				}
				
		
		
	}  
   
   
    
    
 public void intcomponent(){
 
        jLabel1 = new JLabel();
        L1 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        name = new JTextField();
        password = new JTextField();
        email = new JTextField();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jLabel2 = new JLabel();
        jButton3 = new JButton();
        jLabel7 = new JLabel();
        jButton4 = new JButton();

   
     
     jLabel1.setText("Username:");

     
 //username
 L1 = new JLabel();
  
L1.setBounds(100, 10, 130, 30);
 

jLabel1.setBounds(10, 10, 90, 30);
jLabel1.setText("Username:");

  jLabel7.setBounds(40, 90, 200, 20);
 jLabel7.setText("UPDATE PERSONAL DATA:");

//label username
 jLabel3.setBounds(20, 120, 100, 30);
jLabel3.setText("USERNAME:");


name.setBounds(110, 120, 140, 30);



//passord label
jLabel4.setBounds(20, 160, 90, 30);
jLabel4.setText("Password:");

password.setBounds(110, 160, 140, 30);

//email label
jLabel5.setBounds(20, 190, 80, 30);

jLabel5.setText("Email:");

email.setBounds(110, 200, 140, 30);

 
//button

jButton1.setBounds(80, 260, 70,20);

jButton1.setText("Show");

//show button
jButton1.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        showActionPerformed(evt);
    }
});


  //updatebutton

jButton2.setBounds(180, 260,100,20);
     
jButton2.setText("Update");

jButton2.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        updateActionPerformed(evt);
    }
});

//Logout Button
jButton4.setBounds(520, 260, 100, 30);
jButton4.setText("LOG OUT");

jButton4.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        LogoutActionPerformed(evt);
    }
});

// quiz buttion 
 // jButton3.setBackground(new java.awt.Color(0, 0, 153));

jButton3.setBounds(470, 10, 150, 30);

jButton3.setText("Start Your Quiz");

jButton3.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        QuizButtonActionPerformed(evt);
    }
});


     
     
 //Frame add component    
  this.setLayout(null);
 this.add(L1);
 this.add(jLabel1);
 
 this.add( jLabel7);
 
 this.add(jLabel3);
 
 this.add(jLabel4);
 this.add(jLabel5);
 this.add(name);
 
 this.add(password);
 
 this.add(email);
 
 this.add(jButton1);
 this.add(jButton2);
 this.add(jButton4);
  this.add(jButton3);
 //Frame
     
  this.setSize(650,400);
  this.setTitle(" Student Profile");
  this.setVisible(true);
    
 
  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       
       
 
 } 
 
    //usershow
 
 private void showActionPerformed(java.awt.event.ActionEvent evt) { 
 
     
     
      try{
					
					//int row=table.getSelectedRow();
					//String id=(table.getModel().getValueAt(row,0 )).toString();
					

					String sql = "SELECT * from employ where username='"+L1.getText()+"'";          //+id+ means variable
					PreparedStatement statement = conn.prepareStatement(sql);
				     
					
					
					
					
					ResultSet result = statement.executeQuery();
					
					
					
					while(result.next()){
					
						
						//Id.setText(result.getString("id"));
                                                password.setText(result.getString("password"));
						name.setText(result.getString("username"));
						email.setText(result.getString("email"));
						
						
					}
					
				
					
					statement.close();
					
					
					
					
					
					
				}catch(Exception e2){
					
					e2.printStackTrace();
					
				}
 
 
 
 
 
 
 }
 
 
 
 //update 
 
  
 
    private void updateActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
         int upd=JOptionPane.showConfirmDialog(null,"Do you want to Update ?","UPDATE",JOptionPane.YES_NO_OPTION );
        if(upd==0){
				try{

					String sql = "Update employ set username='"+ name.getText() +"',password='"+ password.getText() +"',email='"+ email.getText() +"'WHERE username='"+L1.getText() +"' ";
					
					 
				
                                        PreparedStatement statement = conn.prepareStatement(sql);
				
					
					
					statement.execute();
					
					JOptionPane.showMessageDialog(null,"Update  data successfully");
					
					statement.close();
					
					
					
					
				
					
				}catch(Exception e2){
					
					e2.printStackTrace();
					
				}
				
				
				
				//Refresh();	//call refresh function	
				} 
        
        
        
    }                                        
 
private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {                                         
  Log_in  l1 =new Log_in();

  l1.setVisible(true);
  this.setVisible(false);

        // TODO add your handling code here:
    }                                        

    
//quiz Start Button    
    
        
    private void QuizButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
      
    
        UserS qu=new UserS();
        
         UserS.username_rcv.setText(this.L1.getText());
        
        
        qu.setVisible(true);
        this.setVisible(false);
    }  
    
    
    public static void main(String[] args) {
        new Profile();
    }
 
 
 
    
 
    
}

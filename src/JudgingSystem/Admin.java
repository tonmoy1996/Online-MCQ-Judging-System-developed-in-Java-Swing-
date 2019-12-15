
package JudgingSystem;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.awt.event.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Admin extends JFrame{
    
    public static JLabel L11;
    private JTextField email;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JTextField name;
    private JTextField password;
    
    
    
    
    
    
    Connection conn =null;
    Admin()
    {
      intcomponent();
        conn=Javaconnect.dbConnection();
         Refresh();
    
    }
    
    public void close(){
    
    WindowEvent WinClosingEventeEvent=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
    
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(WinClosingEventeEvent);
    
    
    }
    
    
    public void Refresh(){
		try{
		String sql = "SELECT *from admin where username='"+L11.getText()+"'";          //+id+ means variable
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
    
    
    
    
    
   public void   intcomponent()
     {
     
         jButton1 = new JButton();
        jButton2 = new JButton();
        jLabel1 = new JLabel();
        L11 = new JLabel();
        name = new JTextField();
        password = new JTextField();
        email = new JTextField();
        jButton3 = new JButton();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jLabel5 = new JLabel();
     
        this.setLayout(null);
     
         jLabel1.setBounds(10, 10, 100, 30);
         //username
         jLabel1.setText("USER NAME:");
         
         L11.setBounds(110, 10, 130, 20);

   //show username
   
         jLabel2.setBounds(130, 130, 50, 20);
         jLabel2.setText("NAME:");
  //nametext
        name.setBounds(100, 150, 130, 30);

    //passordlabel
    
        jLabel3.setBounds(127, 200, 90,20);
       jLabel3.setText("PASSWORD :");

     //passordtext
     
       password.setBounds(100, 220, 130, 30);
       
       
       //email label
       jLabel4.setBounds(140, 270, 90, 20);
       jLabel4.setText("EMAIL :");

   email.setBounds(100, 290, 130, 30);

//show button
   

 jButton3.setBounds(110, 360, 90, 35);
   jButton3.setText("SHOW");

jButton3.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        showActionPerformed(evt);
    }
});


//logout button


jButton4.setBounds(513, 410, 100, 35);
jButton4.setText("LOG OUT");

jButton4.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
       logoutActionPerformed(evt);
    }
});


  //showuser
  
  jButton1.setBounds(360, 20, 130, 35);
  jButton1.setText("Show User");

jButton1.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
       showuserActionPerformed(evt);
    }
});



//upload question


jButton2.setBounds(500, 20, 130, 35);
jButton2.setText("Upload Question");

jButton2.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        uploadQuestionActionPerformed(evt);
    }
});


//edit question


jButton5.setBounds(430,70, 130, 35);
jButton5.setText("EDIT QUESTION");

jButton5.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        editQuestionActionPerformed(evt);
    }
});


   
  //add components
  this.add(jLabel1);
  
  this.add(L11);
  this.add(jLabel2);

  this.add(name);
  this.add(jLabel3);
  this.add(password);
  this.add(jLabel4);
  
  this.add(email);
  
  this.add(jButton3);
  
  
  this.add(jButton4);
  this.add(jButton1);
  this.add(jButton2);
  this.add(jButton5);
  
  
  
  
  
 this.setSize(650, 500);
  this.setTitle("Admin Profile");
  this.setVisible(true);
    
 
  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
         
     
     
     }
   
   
   private void showActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        
           try{
					
					//int row=table.getSelectedRow();
					//String id=(table.getModel().getValueAt(row,0 )).toString();
					

					String sql = "SELECT *from admin where username='"+L11.getText()+"'";          //+id+ means variable
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
   
   
   private void logoutActionPerformed(java.awt.event.ActionEvent evt) {                                         
Log_in  l1 =new Log_in();

l1.setVisible(true);
this.setVisible(false);


        
    }
   
   //user show in
   
   private void showuserActionPerformed(java.awt.event.ActionEvent evt) {                                         
   

//close();

//a1.setVisible(false);
 Showdata s = new Showdata();
  
 s.admin_rcv_name.setText(this.L11.getText());
 
  s.setVisible(true);
  this.setVisible(false);





        
    }      
   
   //upload question
   
   
   private void uploadQuestionActionPerformed(java.awt.event.ActionEvent evt) {                                         
      Ques_subject q1 = new Ques_subject();
     q1.setVisible(true);
     this.setVisible(false);


        
    }                                        

   //edit question
   
 private void   editQuestionActionPerformed(java.awt.event.ActionEvent evt) {                                         

  //ShowQus q = new ShowQus();
  
 // q.setVisible(true);
  //this.setVisible(false);


 }
   
   
   
   public static void main(String [] args)
   {
       new Admin();
   }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JudgingSystem;

//import static Q2aSystem.Ques_subject.admin_Ques_sub_username;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;


public class UserS extends  JFrame{
    
    private JComboBox comboBoxData;
    private JButton go_to_questionFrame;
    private JButton jButton2;
  
    private JLabel jLabel1;
    private JLabel jLabel2;
    public static JLabel select_sub;
     public  JLabel username;
     public static  JLabel username_rcv;
    
    Connection conn =null;
    public UserS() {
      Inicomponent(); 
      conn=Javaconnect.dbConnection();   
       ShowCombobox(); 
        
    }
 //show conmbobox value
    
    public void ShowCombobox(){
		
		try{
			String sql = "SELECT * FROM subject";
			 
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			//table.setModel(DbUtils.resultSetToTableModel(result));
			
			while(result.next()){
			
				
				comboBoxData.addItem(result.getString("sub"));
				
				
			}
			
			
			}catch(Exception e1){
				
				e1.printStackTrace();
				
				
			}
		
		
		
		
		
	}
    
    
    
    
   public void Inicomponent(){   
      //variable allocation
       
       
        comboBoxData = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        select_sub = new javax.swing.JLabel();
        go_to_questionFrame = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
         username = new javax.swing.JLabel();
         username_rcv = new javax.swing.JLabel();
  
//comboBox set
        
        comboBoxData.setBounds(20, 150, 150, 30);
        
    comboBoxData.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        comboBoxDataActionPerformed(evt);
    }
});
        
        
//  sub jalabel
    jLabel2.setText("Subject:");
    jLabel2.setBounds(320, 150, 100, 30);

//text field
    select_sub.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));


    select_sub.setBounds(400, 150, 180, 30);
        
   //username Label
          username.setBounds(10, 10, 100, 30);
         
         username.setText("Username:");
        
  //rcv username
           username_rcv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
         username_rcv.setBounds(100, 10, 150, 30);
         
 // Go to Button
         
  go_to_questionFrame.setText("Go To");

go_to_questionFrame.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        go_to_questionFrameActionPerformed(evt);
    }
});


go_to_questionFrame.setBounds(450,200, 80, 30);

// add back Button

jButton2.setBounds(10, 370, 90, 30);

 jButton2.setBackground(new java.awt.Color(255, 51, 48));

jButton2.setText("BACK");

jButton2.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        BackButtonActionPerformed(evt);
    }
});







       
 //add frame to component
   this.setLayout(null);
   this.add(comboBoxData);
   this.add(jLabel2);
   this.add(select_sub);
   this.add(username);
   this.add(username_rcv);
   this.add(go_to_questionFrame);
   this.add(jButton2);
        
        
       
 
        
  //main frame      
  this.setSize(620,450);
  this.setTitle(" Subject Choose");
  this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);   
 
    
 }  
    
    
 //comboBox data
   
   private void comboBoxDataActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:

        try{

            String sql = "SELECT * from subject where sub=?  ";
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1,(String)comboBoxData.getSelectedItem());

            ResultSet result = statement.executeQuery();

            while(result.next()){

                select_sub.setText(result.getString("sub"));
                //name.setText(result.getString("name"));
                //email.setText(result.getString("email"));

            }

            statement.close();

        }catch(Exception e2){

            e2.printStackTrace();

        }

    }                
   
  //Go to Button
   
   private void go_to_questionFrameActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:

      //  question qu =new question();
        //QuestionFrame .subject.setText(select_sub.getText());
        //QuestionFrame .admin_jlabel2.setText(admin_Ques_sub_username.getText());
      //  qu.setVisible(true);
       // this.setVisible(false);

    }      
    
 //Back Button
   
     private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        Profile q2 =new Profile();

        q2.setVisible(true);
        this.setVisible(false);       
    }                                        

   
 
    public static void main(String[] args) {
        
        new UserS();
    }
     
    
    
}

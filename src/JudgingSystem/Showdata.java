/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JudgingSystem;

import java.awt.EventQueue;  
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.text.MessageFormat;
import java.awt.print.* ;
import java.text.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;


public class Showdata extends JFrame{
   //Variable declariation
    
     private JTextField Id;
    private JButton cmd_print;
    private JComboBox comboBoxData;
    private JTextField email;
    private JButton jButton1;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton7;
  
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
  public static  JLabel admin_rcv_name;
  //  private JScrollPane jScrollPane1;
    
    private JTextField name;
    private JTable table;
    private JTextField textFieldSearch;
    
   Connection conn =null;
   public Showdata() {
        Intcomponent();
      //  Connection conn =null;
        conn=Javaconnect.dbConnection();
        Refresh();
        ShowCombobox();
            
    }
    
   public void Refresh(){
		
		try{
                  //Admin a= new Admin();  
                    
        //jLabel7.setText(Admin.L11);
			String sql = "SELECT * FROM employ";
			 
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			table.setModel(DbUtils.resultSetToTableModel(result));
			
			
			}catch(Exception e1){
				
				e1.printStackTrace();
				
				
			}
		
		
		
		
		
	}
public void ShowCombobox(){
		
		try{
			String sql = "SELECT * FROM employ";
			 
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			//table.setModel(DbUtils.resultSetToTableModel(result));
			
			while(result.next()){
			
				
				comboBoxData.addItem(result.getString("username"));
				
				
			}
			
			
			}catch(Exception e1){
				
				e1.printStackTrace();
				
				
			}
		
		
		
		
		
	}
	
   
 public void Intcomponent(){   
    
        
        table = new JTable();
        jButton1 = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        Id = new JTextField();
        name = new JTextField();
        email = new JTextField();
        jButton3 = new JButton();
        jButton4 = new JButton();
        comboBoxData = new JComboBox();
        jLabel4 = new JLabel();
        textFieldSearch = new JTextField();
        jButton5 = new JButton();
        cmd_print = new JButton();
        jButton7 = new JButton();
        jLabel6 = new JLabel();
       
        jLabel5 = new  JLabel();
        admin_rcv_name = new JLabel();
 //admin name Label
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel5.setText("ADMIN : ");
        
        jLabel5.setBounds(5, 0, 100, 30);

        
 //admin_rcv_name
      admin_rcv_name.setFont(new java.awt.Font("Tahoma", 1, 18));    
     admin_rcv_name.setBounds(85, 0, 100, 30);  
      
 //add combobox
     
     comboBoxData.setBounds(10, 52, 170, 30);
    comboBoxData.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
     comboBoxDataActionPerformed(evt);
    }
});

//Label ID
   jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));    
    jLabel1.setBounds(10,170,70,20);
    jLabel1.setText("ID:");
//ID Text Field
    
   Id.setBounds(90, 165, 150,30); 
   
//name label
    jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); 
   jLabel2.setBounds(10, 220, 120,30);
   jLabel2.setText("Name:");
  //name textfield
   
   name.setBounds(90, 220, 150,30);
   
 //email label
   jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); 
   jLabel3.setBounds(10, 275, 120,30);
   jLabel3.setText("Email:");
  //email textfield
   
   email.setBounds(90, 275, 150,30);
  // Back Button
   
   
jButton7.setBounds(10,410, 80, 30);
jButton7.setText("BACK");

jButton7.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
       BackbuttonActionPerformed(evt);
    }
});

//clear Button

jButton5.setBounds(20, 330, 80, 30);
jButton5.setText("Clear");

jButton5.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
       ClearButtonActionPerformed(evt);
    }
});

// update button

jButton3.setBounds(110, 330, 80, 30);
jButton3.setText("Update");

jButton3.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        UpdateButtonActionPerformed(evt);
    }
});

//delete button
jButton4.setBounds(200, 330, 80, 30);
jButton4.setText("Delete");

jButton4.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
       DeleteButtonActionPerformed(evt);
    }
});

//table
Object [] Columns={};     //"id","name","age"
        DefaultTableModel model=new DefaultTableModel();
        model.setColumnIdentifiers(Columns);
       
        table.setModel(model);
        
        JScrollPane jt = new JScrollPane(table);
   
        jt.setBounds(300,165,500,270);

  //mouse clicked 
        
        table.addMouseListener(new java.awt.event.MouseAdapter() {
  
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        
        
 //Search 
         jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18));    
         jLabel4.setBounds(580,15,70,20);
         jLabel4.setText("Search:");
  //Textfield SeARCH 
         
textFieldSearch.setBounds(660,10,130,30);
textFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
    public void keyReleased(java.awt.event.KeyEvent evt) {
      textFieldSearchKeyReleased(evt);
    }
});
         
         
         
  //addcomponent to frame
  this.setLayout(null);
    this.add(jt);
  this.add(jLabel5);
  this.add(admin_rcv_name);
  this.add(comboBoxData);
  this.add(jLabel1);
  this.add(Id);
  this.add(jLabel2);
  this.add(name);
  this.add(jLabel3);
  this.add(email);
  this.add(jButton7);
    this.add(jButton5);
    this.add(jButton3);
     this.add(jButton4);
     this.add(jLabel4);
     this.add(textFieldSearch);
   
  //main frame
        
        
  this.setSize(825,485);
  this.setTitle(" Show user");
  this.setVisible(true);
    
 
  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
             
    
    
    
 }   
    
//combobox data
 
 private void comboBoxDataActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        
        
        try{

					String sql = "SELECT * from employ where username=?  ";
					PreparedStatement statement = conn.prepareStatement(sql);
				     
					statement.setString(1,(String)comboBoxData.getSelectedItem());
					
					
					
					ResultSet result = statement.executeQuery();
					
					
					
					while(result.next()){
					
						
						Id.setText(result.getString("id"));
						name.setText(result.getString("username"));
						email.setText(result.getString("email"));
						
						
					}
					
				
					
					statement.close();
					
					
					
					
					
					
				}catch(Exception e2){
					
					e2.printStackTrace();
					
				}
				
        
    }                                            
//Back button action
 
 private void BackbuttonActionPerformed(java.awt.event.ActionEvent evt) {                                         
   // Admin  l1 =new Admin();

   //l1.setVisible(true);
  //this.setVisible(false);        
    }           
 
 //clear Button
 
  private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        
        Id.setText(null);
        name.setText(null);
        email.setText(null);
        textFieldSearch.setText(null);
        
        
    }         
    
//update Button
  
   private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
       int upd=JOptionPane.showConfirmDialog(null,"Do you want to Update ?","UPDATE",JOptionPane.YES_NO_OPTION );
				if(upd==0){
				try{

					String sql = "Update employ set username='"+ name.getText() +"',email='"+ email.getText() +"'WHERE id='"+Id.getText() +"' ";
					
					 
					PreparedStatement statement = conn.prepareStatement(sql);
				
					
					
					statement.execute();
					
					JOptionPane.showMessageDialog(null,"Update  data successfully");
					
					statement.close();
					
					
					
					
				
					
				}catch(Exception e2){
					
					e2.printStackTrace();
					
				}
				
				
				
				Refresh();	//call refresh function	
				} 
        
        
    }                                        
//Delete action perform
   
    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        
        
        	int del=JOptionPane.showConfirmDialog(null,"Do you want to Delete ?","Delete",JOptionPane.YES_NO_OPTION );
				if(del==0){
				try{
					

					String sql = "DELETE FROM employ WHERE id='"+Id.getText() +"' ";
					
					 
					PreparedStatement statement = conn.prepareStatement(sql);
				
					
					
					statement.execute();
					
					JOptionPane.showMessageDialog(null,"DELETE  data successfully");
					
					statement.close();
					
					
					
					
					
					
				}catch(Exception e2){
					
					e2.printStackTrace();
					
				}
				
				
				Refresh();	//call refresh function	
				}
        
        
     
    }                                 
 //Table mouse clicked
    
     private void tableMouseClicked(java.awt.event.MouseEvent evt) {                                   
        // TODO add your handling code here:
        
        try{
					
					int row=table.getSelectedRow();
					String id=(table.getModel().getValueAt(row,0 )).toString();
					

					String sql = "SELECT *from employ where id='"+id+"'";          //+id+ means variable
					PreparedStatement statement = conn.prepareStatement(sql);
				     
					
					
					
					
					ResultSet result = statement.executeQuery();
					
					
					
					while(result.next()){
					
						
						Id.setText(result.getString("id"));
						name.setText(result.getString("username"));
						email.setText(result.getString("email"));
						
						
					}
					
				
					
					statement.close();
					
					
					
					
					
					
				}catch(Exception e2){
					
					e2.printStackTrace();
					
				}
				
				
        
        
        
    }                            
    
 //search field
     private void textFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {                                            
        // TODO add your handling code here
         try{

					String sql = "SELECT *from employ where id=?";
					PreparedStatement statement = conn.prepareStatement(sql);
				     
				statement.setString(1,textFieldSearch.getText());
				
					
					
					ResultSet result = statement.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(result));
					
				
				
					
					statement.close();
                                        
                                        
					
					
					
					
					
					
				}catch(Exception e2){
					
					e2.printStackTrace();
					
				}
        
      
    
        
    }                    
   
    
    public static void main(String[] args) {
        
        new Showdata();
    }
  

 
 
}

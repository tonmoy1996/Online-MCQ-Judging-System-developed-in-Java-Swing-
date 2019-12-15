
package JudgingSystem;

import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ques_subject extends JFrame{
    
     private JTextField add_subject;
    public JLabel admin_Ques_sub_username;
    private JComboBox comboBoxData;
    private JButton go_to_questionFrame;
    private JButton jButton1;
    private JButton jButton2;
    private JDesktopPane jDesktopPane1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JPanel jPanel1;
    public static JLabel select_sub;
    
    
    
    
    
   Connection conn =null;
    public Ques_subject() {
        initComponents();
        
        conn=Javaconnect.dbConnection();
      //  refresh();
       ShowCombobox();
       
    }
    
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
	
    
    
     public void refresh(){
     
  
 
  try{
			String sql = "SELECT * FROM subject";
			 
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			//table.setModel(DbUtils.resultSetToTableModel(result));
			
			while(result.next()){
			
				
				comboBoxData.addItem(result.getString("sub"));
				
				
			}
			
			add_subject.setText(null);
			}catch(Exception e1){
				
				e1.printStackTrace();
				
				
			}
		
		
        
 }   
    
     
     
    
   public void initComponents()
   {
        comboBoxData = new JComboBox();
        admin_Ques_sub_username = new JLabel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        select_sub = new JLabel();
        go_to_questionFrame = new JButton();
        jPanel1 = new JPanel();
        jLabel3 = new JLabel();
        add_subject = new JTextField();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jLabel4 = new JLabel();
        jDesktopPane1 = new JDesktopPane();
        
        
        this.setLayout(null);
        
        
        //select sub combobox
        
        
 admin_Ques_sub_username.setBounds(100, 10, 140, 30);
comboBoxData.setBounds(40, 80, 190, 30);
comboBoxData.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Sub" }));

comboBoxData.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
      comboBoxDataMouseClicked(evt);
    }
});
comboBoxData.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
       comboBoxDataActionPerformed(evt);
    }
});
     
        
        select_sub.setBounds(360, 80, 180, 30);

        
        
        //go to botton
        go_to_questionFrame.setBounds(480, 120,100,30);
        go_to_questionFrame.setText("Go To");

go_to_questionFrame.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        go_to_questionFrameActionPerformed(evt);
    }
});


//jpanel set



  //add subject
  
 jPanel1.setBounds( 190, 300, 230, 40);
  jLabel3.setText("Add Subject");

  jPanel1.add(jLabel3);
  
  
jLabel2.setBounds(280, 80, 100, 30);
 jLabel2.setText("Subject:");

 //add subject text
 
 add_subject.setBounds(90, 370, 220, 30);


 //add new subject button
 
 jButton1.setBounds(330, 370, 230, 30);
 
jButton1.setText("Add  New Subject");

jButton1.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        newSubjectActionPerformed(evt);
    }
});


 
        
        
        //add components
        
        this.add(comboBoxData);
        this.add(admin_Ques_sub_username);
        this.add(select_sub);
        this.add(go_to_questionFrame);
        
       this.add(jPanel1);
        this.add(jLabel2);
        this.add(add_subject);
        this.add(jButton1);
        
        
        
        
        this.setSize(650, 500);
  this.setTitle("Question Frame");
  this.setVisible(true);
        
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);    
   
   }
   
   
   
   
   //showcombobox 
   
   private void comboBoxDataActionPerformed(java.awt.event.ActionEvent evt) {                                             
       
         
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

   
 
   
    private void comboBoxDataMouseClicked(java.awt.event.MouseEvent evt) {                                          
        // TODO add your handling code here:
    } 
    
    
    
    //goto button action
    private void go_to_questionFrameActionPerformed(java.awt.event.ActionEvent evt) {                                                    
    
        
        
           // QuestionFrame qu =new QuestionFrame();
          //  QuestionFrame .subject.setText(select_sub.getText());
           // QuestionFrame .admin_jlabel2.setText(admin_Ques_sub_username.getText());
          //  qu.setVisible(true);
           this.setVisible(false);
            
        
    }    
    
    
    
    //action performed of new subject 
    
    
   private void  newSubjectActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        
         int insert=JOptionPane.showConfirmDialog(null,"Do you want to Insert ?","INSERT",JOptionPane.YES_NO_OPTION );
				if(insert==0){
				
				try{
					
					String sql = "INSERT INTO subject (sub) VALUES (?)";
					
					PreparedStatement statement = conn.prepareStatement(sql);
					statement.setString(1,add_subject.getText());
					
					
					statement.execute();
					
					JOptionPane.showMessageDialog(null,"Save data successfully");
					
					statement.close();
					
					
				
					Ques_subject s =new Ques_subject();
                                        s.setVisible(true);
                                        this.setVisible(false);
					
				//	 refresh();
					
					
				}catch(Exception e2){
					
					e2.printStackTrace();
					
				}
				

			    //call refresh function	
				
			}	 
        
        
       refresh(); 
        
        
    }   

    
    
    public static void main(String[] args) {
        new Ques_subject();
    }
    
    
}

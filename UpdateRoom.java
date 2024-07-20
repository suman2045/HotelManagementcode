
package HOTELMANGEMENTSYSTEM1;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;




public class UpdateRoom extends JFrame implements ActionListener{
    
    Choice ccustomer;
    JTextField tfroom , tfname, tfcheckin, tfpaid,tfpending ;
    JButton check, update, back;
   
    
    
    UpdateRoom(){
       getContentPane().setBackground(Color.WHITE);
        setLayout(null);
       JLabel heading = new JLabel("Update Room Status");
       heading.setBounds(30, 20, 250, 30);
       heading.setFont(new Font("Tohoma",Font.PLAIN, 25));
       heading.setForeground(Color.BLUE);
       add(heading);
       
         JLabel lblid = new JLabel("Customer Id");
       lblid.setBounds(30, 80, 100, 20);
       add(lblid);
         ccustomer = new Choice();
         ccustomer.setBounds(200,80,150,25);
         add(ccustomer);
         
         try{
             Conn c = new Conn();
             ResultSet rs = c.s.executeQuery("select * from customer");
             while(rs.next()){
                 ccustomer.add(rs.getString("number"));
             }
             
         }catch(Exception e){
             e.printStackTrace();
         }
        
         JLabel lblroom = new JLabel("Room Number");
       lblroom.setBounds(30, 130, 100, 20);
       add(lblroom);
       
        tfroom = new JTextField();
        tfroom.setBounds(200, 130, 150, 25);
        add(tfroom);
        
        
         JLabel lblname = new JLabel("Availability");
       lblname.setBounds(30, 180, 100, 20);
       add(lblname);
       
        tfname = new JTextField();
        tfname.setBounds(200, 180, 150, 25);
        add(tfname);
        
          
         JLabel lblcheckin = new JLabel("Cleaning Status");
       lblcheckin.setBounds(30, 230, 100, 20);
       add(lblcheckin);
       
        tfcheckin = new JTextField();
        tfcheckin.setBounds(200, 230, 150, 25);
        add(tfcheckin);
        
         
        
        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30,300,100,30);
        check.addActionListener(this);
        add(check);
       
        
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150,300,100,30);
        update.addActionListener(this);
        
        add(update);
       
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270,300,100,30);
        back.addActionListener(this);
        
        add(back);
               
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/seventh.jpg"));
     Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
     ImageIcon i3 = new ImageIcon(i2);
     JLabel image = new JLabel(i1);
     image.setBounds(400,50,500,300);
     add(image);
       
        
   
        setBounds(300,200,980,450);
        setVisible(true);
        
    }
    
    
    
    public static void main(String[] args) {
        new UpdateRoom();
        
    }
    
    

    //@Override
    
       

    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
      if(ae.getSource() == check){
            String id = ccustomer.getSelectedItem();
            String qu = "select * from customer where number = '"+id+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(qu);
                while(rs.next()){
                    tfroom.setText(rs.getString("room"));
                   
                    }
              ResultSet rs2 = c.s.executeQuery("select * from addroom where roomnumber='"+tfroom.getText()+"'");
                while(rs2.next()){
                    tfname.setText(rs2.getString("availability"));
                    tfcheckin.setText(rs2.getString("status"));
                }
                             
                           
                                
            }catch(Exception e){
                e.printStackTrace();
                
            }  
      }
            
           else if (ae.getSource() == update) {
    String number= ccustomer.getSelectedItem();
    String room = tfroom.getText();
    String available = tfname.getText();
    String Status = tfcheckin.getText();

    try {
        Conn c = new Conn();
        String query = "update addroom set availability = '" + available + "', status = '" + Status +  "' WHERE roomnumber = '" + room + "'";
        c.s.executeUpdate(query);

        JOptionPane.showMessageDialog(null, "Data Updated Successfully");
        setVisible(false);
        new Reception();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

            
                    
            
       
            
        else if(ae.getSource()== back){
            setVisible(false);
            new Reception();
            
               
    }
    }  
}
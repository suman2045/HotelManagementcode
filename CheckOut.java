
package HOTELMANGEMENTSYSTEM1;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.util.Date;
import java.awt.event.*;



public class CheckOut extends JFrame implements ActionListener{
    Choice ccustomer;
    JLabel lblroomnumber , lblcheckin , lblcheckout;
    JButton checkout,back;
    
   CheckOut(){
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
       JLabel text = new JLabel("Checkout");
       text.setBounds(100,20,100,30);
       text.setForeground(Color.BLUE);
       text.setFont(new Font("Tahoma",Font.PLAIN,20));
       add(text);
       
        JLabel lblid = new JLabel("Customer ID");
       lblid.setBounds(30,80,100,30);
       add(lblid);
        ccustomer = new Choice();
         ccustomer.setBounds(150,80,150,25);
         add(ccustomer);
         
        
       
         
       JLabel lblroom = new JLabel("Room Number");
       lblroom.setBounds(30,130,100,30);
             add(lblroom);
       
              lblroomnumber = new JLabel();
             lblroomnumber.setBounds(150, 130, 100, 30);
       add(lblroomnumber);
       
       
        JLabel lblcheckintime= new JLabel("Checkin Time");
       lblcheckintime.setBounds(30,180,100,30);
             add(lblcheckintime);
       
       
              lblcheckin = new JLabel();
             lblcheckin.setBounds(150, 180, 100, 30);
       add(lblcheckin);
       
       
        JLabel lblcheckouttime = new JLabel("Checkout Time");
       lblcheckouttime.setBounds(30,230,100,30);
             add(lblcheckouttime);
             
             Date date = new Date();
       
       
              lblcheckout = new JLabel("" + date);
             lblcheckout.setBounds(150, 230, 150, 30);
       add(lblcheckout);
       
       checkout =  new JButton("Checkout");
       checkout.setBackground(Color.BLACK);
       checkout.setForeground(Color.WHITE);
       checkout.setBounds(30, 280, 120, 30);
       checkout.addActionListener(this);
       add(checkout);
       
       
        back =  new JButton("Back");
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.setBounds(170, 280, 120, 30);
       back.addActionListener(this);
       add(back);
       
        try{
             Conn c = new Conn();
             ResultSet rs = c.s.executeQuery("select * from customer");
             while(rs.next()){
                 ccustomer.add(rs.getString("number"));
                 lblroomnumber.setText(rs.getString("room"));
                 lblcheckin.setText(rs.getString("checkintime"));
             }
             
         }catch(Exception e){
             e.printStackTrace();
         }


       
       setBounds(300,200,800,400);
       setVisible(true);
       
       
   }
   
   
    public static void main(String[] args) {
        new CheckOut();
    }

    /*@Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource()==checkout){
           String query1 = "delete from customer where number = '" + ccustomer.getSelectedItem()+"'";
           String query2 = "update addroom set availability = 'Available where room='" +lblroomnumber.getText() +"'";
           
     
            try{
                Conn c = new Conn();
               c.s.executeUpdate(query1);
               c.s.executeUpdate(query2);
                
               
               JOptionPane.showMessageDialog(null,"Checkout done" );
                                setVisible(false);
                                new Reception();
            }catch(Exception e){
                e.printStackTrace();
                
            }  
       }
       else{
           setVisible(false);
           new Reception();
           
       }
    }*/
    
    @Override
public void actionPerformed(ActionEvent ae) {
    if(ae.getSource()==checkout){
        String query1 = "delete from customer where number = '" + ccustomer.getSelectedItem() +"'";
        String query2 = "update addroom set availability = 'Available' where roomnumber='" +lblroomnumber.getText() +"'";
        
        try{
            Conn c = new Conn();
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            
            JOptionPane.showMessageDialog(null,"Checkout done" );
            setVisible(false);
            new Reception();
        }catch(Exception e){
            e.printStackTrace();
        }  
    }
    else{
        setVisible(false);
        new Reception();
    }
}
 }





package HOTELMANGEMENTSYSTEM1;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;
public class AddCustomer extends JFrame implements ActionListener {
    
    JComboBox comboid;
  
    
    JTextField tfnumber ,tfname , tfcon , tfdep;
    JRadioButton rmale,rfemale;
    Choice croom;
    JLabel checkintime;
    JButton add, back;
    
    
    
    
    AddCustomer(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
          JLabel heading = new JLabel("New Customer Form");
    heading.setFont(new Font("Raleway",Font.BOLD, 20));
    heading.setBounds(100,20,300,30);
    heading.setForeground(Color.BLUE);
    add(heading);
    
    JLabel lblid = new JLabel("ID");
    lblid.setBounds(35,80,100,20);
    lblid.setFont(new Font("Raleway",Font.PLAIN,20));
    add(lblid);
    
    String options[] ={"Aadhar Card","Passpoprt","Driving License","Voter-id Card"};
       comboid = new JComboBox(options);
       comboid.setBounds(200,80,150,25);
       comboid.setBackground(Color.WHITE);
       add(comboid);
       
        JLabel lblnumber= new JLabel("Number");
    lblnumber.setBounds(35,120,100,20);
    lblnumber.setFont(new Font("Raleway",Font.PLAIN,20));
    add(lblnumber);
    
    tfnumber = new JTextField();
    tfnumber.setBounds(200,120,150,25);
    add(tfnumber);
    
       
        JLabel lblname= new JLabel("Name");
    lblname.setBounds(35,160,100,20);
    lblname.setFont(new Font("Raleway",Font.PLAIN,20));
    add(lblname);
    
    tfname = new JTextField();
    tfname.setBounds(200,160,150,25);
    add(tfname);
    
     JLabel lblgender= new JLabel("Gender");
    lblgender.setBounds(35,200,100,20);
    lblgender.setFont(new Font("Raleway",Font.PLAIN,20));
    add(lblgender);
    
    rmale = new JRadioButton("Male");
    rmale.setBackground(Color.WHITE);
    rmale.setBounds(200,200,60,25);
            add(rmale);
            
    rfemale = new JRadioButton("Female");
    rfemale.setBackground(Color.WHITE);
    rfemale.setBounds(270,200,100,25);
            add(rfemale);
            
     JLabel lblcon= new JLabel("Country");
    lblcon.setBounds(35,240,100,20);
    lblcon.setFont(new Font("Raleway",Font.PLAIN,20));
    add(lblcon);
    
    tfcon = new JTextField();
    tfcon.setBounds(200,240,150,25);
    add(tfcon);
    
     JLabel lblroom= new JLabel("Room Number");
    lblroom.setBounds(35,280,150,20);
    lblroom.setFont(new Font("Raleway",Font.PLAIN,20));
    add(lblroom);
    
    croom = new Choice();
    
    try{
        Conn conn = new Conn();
        String str ="select * from addroom";
        ResultSet rs = conn.s.executeQuery(str);
        while(rs.next()){
            croom.add(rs.getString("roomnumber"));
            
        }
    } catch (Exception e){
        e.printStackTrace();
    }
    croom.setBounds(200,280,150,25);
    add(croom);
    
        JLabel lbltime = new JLabel("Checkin time");
    lbltime.setBounds(35,320,150,20);
    lbltime.setFont(new Font("Raleway",Font.PLAIN,20));
    add(lbltime);
    
    Date date = new Date();
    
     checkintime = new JLabel("" + date);
    checkintime.setBounds(200,320,150,25);
    checkintime.setFont(new Font("Raleway",Font.PLAIN,16));
    add(checkintime);
    
         JLabel lbldep= new JLabel("Deposite");
    lbldep.setBounds(35,360,100,20);
    lbldep.setFont(new Font("Raleway",Font.PLAIN,20));
    add(lbldep);
    
    tfdep = new JTextField();
    tfdep.setBounds(200,360,150,25);
    add(tfdep);
    
     add = new JButton("Add");
    add.setForeground(Color.WHITE);
    add.setBackground(Color.BLACK);
    add.setBounds(50,410,120,30);
   add.addActionListener(this);
    add(add);
    
    back= new JButton("Back");
    back.setForeground(Color.WHITE);
    back.setBackground(Color.BLACK);
    back.setBounds(200,410,120,30);
    back.addActionListener(this);
    add(back);
    
    
     ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("Icon/fifth.png"));
       Image i2 =i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image =new JLabel(i3);
       image.setBounds(400,50,300,400);
       add(image);
             setBounds(350,200,800,550);
       
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource() == add)
        {
            String id = (String)comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = null;
            
            if(rmale.isSelected()){
                gender = "Male";
                
            }else{
                gender = "Female";
            }
           
            String country = tfcon.getText();
            String room = croom.getSelectedItem();
            String time = checkintime.getText();
            String deposite = tfdep.getText();
            
            try{
                Conn conn = new Conn();
               
            String query = "insert into customer values('" + id + "','" + number + "','" + name + "','" + gender + "','" + country + "','" +room + "','" + time + "','"+ deposite +"')";

           String query2 = "update addroom set availability = 'Occupied' where roomnumber ='" +room+"'";
           conn.s.executeUpdate(query);
           conn.s.executeUpdate(query2);
                 
           JOptionPane.showMessageDialog(null,"New Customer Added Successfully");
           this.setVisible(false);
              
              
                
                        
            }catch(HeadlessException | SQLException e){
                e.printStackTrace();
            }
            
            
            
        }
        else{
            setVisible(false);
             new Reception();
             
        }
    }
    public static void main(String[] args) {
        AddCustomer addCustomer = new AddCustomer();
        
    }

    
}

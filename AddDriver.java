
package HOTELMANGEMENTSYSTEM1;

import HOTELMANGEMENTSYSTEM1.Conn;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
//import java.awt.event.*;






public class AddDriver extends JFrame implements ActionListener {

    
    
    JButton add, cancel;
    JTextField tfname,tfage, tfcar,tfmodel,tfloc;
    JComboBox cbgen,cbav;
    AddDriver()
    {
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    JLabel heading = new JLabel("Add Drivers");
    heading.setFont(new Font("Tahoma",Font.BOLD, 18));
    heading.setBounds(150,10,200,50);
    add(heading);

    JLabel lblname = new JLabel("Name");
    lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
    lblname.setBounds(60,70,120,20);
     add(lblname);

     tfname = new JTextField();
     tfname.setBounds(200,80,120,20);
     add(tfname);
     
     JLabel lblage = new JLabel("Age");
     lblage.setFont(new Font("Tahoma",Font.PLAIN,16));
     lblage.setBounds(60,110,120,20);
     add(lblage);
     
     tfage = new JTextField();
     tfage.setBounds(200,110,120,20);
     add(tfage);
     
     
    JLabel lblgender = new JLabel("Gender");
    lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
    lblgender.setBounds(60,150,120,20);
    add(lblgender);

    String genderOption[] = {"Male", "Female"};
    //@SuppressWarnings("rawtypes")
     cbgen = new JComboBox<>(genderOption);
    cbgen.setBounds(200,150,120,20);
    cbgen.setBackground(Color.WHITE);
    add(cbgen);
    
    JLabel lblcar = new JLabel("Car Company");
    lblcar.setFont(new Font("Tahoma", Font.PLAIN,16));
    lblcar.setBounds(60,190,120,30);
    add(lblcar);
    
     tfcar = new JTextField();
    tfcar.setBounds(200,190,120,20);
    add(tfcar);
    
    
    JLabel lblmodel = new JLabel ("Car Model");
    lblmodel.setFont(new Font("Tahoma",Font.PLAIN,16));
    lblmodel.setBounds(60, 230, 150 ,20);
    add(lblmodel);
    
    tfmodel = new JTextField();
    tfmodel.setBounds(200,230,120,20);
    add(tfmodel);
    
     
    JLabel lblavl = new JLabel ("Available");
    lblavl.setFont(new Font("Tahoma",Font.PLAIN,16));
    lblavl.setBounds(60, 270, 150 ,20);
    add(lblavl);
    
    String availOption[] = {"Available", "Busy"};
    //@SuppressWarnings("rawtypes")
     cbav = new JComboBox<>(availOption);
    cbav.setBounds(200,270,150,20);
    cbav.setBackground(Color.WHITE);
    add(cbav);
    
    JLabel lbloc = new JLabel("Location");
    lbloc.setFont(new Font("Tahoma", Font.PLAIN,16));
    lbloc.setBounds(60,310,150,20);
    
    add(lbloc);
    
     tfloc = new JTextField();
    tfloc.setBounds(200,310,120,20);
    add(tfloc);
    
     add = new JButton("Add Room");
    add.setForeground(Color.WHITE);
    add.setBackground(Color.BLACK);
    add.setBounds(60,350,130,30);
    add.addActionListener(this);
    add(add);
    
    cancel = new JButton("Cancel");
    cancel.setForeground(Color.WHITE);
    cancel.setBackground(Color.BLACK);
    cancel.setBounds(250,350,130,30);
    cancel.addActionListener(this);
    add(cancel);
    
    
    
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/eleven.jpg"));
    Image i2 = i1.getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    
   // ImageIcon i1 = new ImageIcon((ClassLoader.getSystemResources("Icons/twelve.jpg"));
   //  JLabel image = new JLabel(i1);
     image.setBounds(400,30,500,300);
     add(image);
     


    setBounds(300, 200, 980,470);
    setVisible(true);

         
     }
    
    public void actionPerformed (ActionEvent ae){
        if(ae.getSource() == add)
        {
            String drivername = tfname.getText();
            String age = tfage.getText();
            String availability = (String) cbav.getSelectedItem();
            String gender = (String) cbgen.getSelectedItem();
            String car = tfcar.getText();
            String brand = tfmodel.getText();
            String loc = tfloc.getText();
            
            try{
                Conn conn = new Conn();
               
               String str = "insert into adddriver values('" + drivername + "','" + age + "','" + availability + "','" + gender + "','" + car + "','" + loc + "','" + brand + "')";

                
                conn.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null,"New Driver Added Successfully");
              this.setVisible(false);
                
                        
            }catch(HeadlessException | SQLException e){
                e.printStackTrace();
            }
            
            
            
        }
        else{
            setVisible(false);
            
        }
    }
    
    



    public static void main(String[] args) {
        new AddDriver();
    }

   
}

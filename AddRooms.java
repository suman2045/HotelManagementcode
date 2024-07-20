package HOTELMANGEMENTSYSTEM1;

import HOTELMANGEMENTSYSTEM1.Conn;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {

    static void addActionListener(Dashboard aThis) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    JButton add, cancel;
    JTextField tfroom,tfprice;
    JComboBox typecombo,cbclean,cbavl;
    AddRooms(){
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    JLabel heading = new JLabel("Add Room");
    heading.setFont(new Font("Tahoma",Font.BOLD, 18));
    heading.setBounds(150,20,200,20);
    add(heading);

    JLabel lblroomno = new JLabel("Room Number");
    lblroomno.setFont(new Font("Tahoma",Font.PLAIN,16));
    lblroomno.setBounds(60,80,120,20);
     add(lblroomno);

     tfroom = new JTextField();
     tfroom.setBounds(200,80,120,20);
     add(tfroom);
     
     JLabel lblav = new JLabel("Available Room");
     lblav.setFont(new Font("Tahoma",Font.PLAIN,16));
     lblav.setBounds(60,130,120,20);
     add(lblav);

     String availableOption[] = { "Avaiable"," Occupied"};
    // @SuppressWarnings("rawtypes")
     cbavl= new JComboBox(availableOption);
    cbavl.setBounds(200,130,130,30);
    cbavl.setBackground(Color.WHITE);
    add(cbavl);

    JLabel lblclean = new JLabel("Cleaning Status");
    lblclean.setFont(new Font("Tahoma",Font.PLAIN,16));
    lblclean.setBounds(60,180,120,20);
    add(lblclean);

    String cleanOption[] = {"Cleaned", "Dirty"};
    //@SuppressWarnings("rawtypes")
     cbclean = new JComboBox<>(cleanOption);
    cbclean.setBounds(200,180,120,30);
    cbclean.setBackground(Color.WHITE);
    add(cbclean);
    
    JLabel lblprice = new JLabel("Price");
    lblprice.setFont(new Font("Tahoma", Font.PLAIN,16));
    lblprice.setBounds(60,230,120,30);
    add(lblprice);
    
     tfprice = new JTextField();
    tfprice.setBounds(200,230,120,30);
    add(tfprice);
    
    
    JLabel lbltype = new JLabel ("Bed Type");
    lbltype.setFont(new Font("Tahoma",Font.PLAIN,16));
    lbltype.setBounds(60, 280, 150 ,30);
    add(lbltype);
    String typeOptions[] = {"Single Bed","Double Bed ","King Bed", "Queen Bed"};
     typecombo = new JComboBox<>(typeOptions);
    typecombo.setBounds(200,280,150,30);
    typecombo.setBackground(Color.WHITE);
    add(typecombo);
    
     add = new JButton("Add Room");
    add.setForeground(Color.WHITE);
    add.setBackground(Color.BLACK);
    add.setBounds(60,350,130,30);
    
    add.addActionListener(this);
    
    add(add);
    
    cancel = new JButton("Cancel");
    cancel.setForeground(Color.WHITE);
    cancel.setBackground(Color.BLACK);
    cancel.setBounds(220,350,130,30);
    cancel.addActionListener(this);
    
    add(cancel);
    
    
    
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/twelve.jpg"));
     JLabel image = new JLabel(i1);
     image.setBounds(400,30,500,300);
     add(image);
     


    setBounds(330, 200, 940,470);
    setVisible(true);

         
     }
    
    public void actionPerformed (ActionEvent ae){
        if(ae.getSource() == add)
        {
            String roomnumber = tfroom.getText();
            String availability = (String) cbavl.getSelectedItem();
            String status = (String) cbclean.getSelectedItem();
            String price = tfprice.getText();
            String type = (String) typecombo.getSelectedItem();
            
            try{
                Conn conn = new Conn();
                //String str = "insert into addroom values('"+ roomnumber +"','"+availability +"' "+ status +"','"+price+"' , ' "+ type+"n')";
                String str = "insert into addroom values('" + roomnumber + "','" + availability + "','" + status + "','" + price + "','" + type + "')";

                
                conn.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null,"New Room Added Successfully");
              this.setVisible(false);
                
                        
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
            
        }
        else{
            setVisible(false);
            
        }
    }
    
    



    public static void main(String[] args) {
        new AddRooms();
    }

   
}

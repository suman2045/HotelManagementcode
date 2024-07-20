package HOTELMANGEMENTSYSTEM1;


import java.awt.Image;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Dashboard extends JFrame implements ActionListener{
   
    Dashboard() {
        setBounds(0,0,1650,2000);
       setLayout(null);
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("Icon/third.jpg"));
       Image i2 =i1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image =new JLabel(i3);
       image.setBounds(0,0,1950,1020);
       add(image);

       JLabel text =new JLabel("THE TAJ GROUP WELCOME YOU");
       text.setBounds(400,80,1000,50);
      text.setFont(new Font ("serif",Font.PLAIN,56));
      text.setForeground(Color.WHITE);
      
       image.add(text);
       JMenuBar mb = new JMenuBar();
       mb.setBounds(0,0,2000,50);
       image.add(mb);
       
       
       JMenu hotel =new JMenu("HOTEL MANGEMENT");
        hotel.setForeground(Color.RED);
       mb.add(hotel);
       
       
       //JMenu reception =new JMenu("RECEPTION");
      JMenuItem reception = new JMenuItem("RECEPTION");
       
       reception.addActionListener(this);
       //reception.add(res);
       hotel.add(reception);
       

       JMenu admin =new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
       mb.add(admin);
       
            
      JMenu addemp = new JMenu("ADD EMPLOYEE");
      JMenuItem addEmpMenuItem = new JMenuItem("Add Employee");
     addEmpMenuItem.addActionListener(this);
     addemp.add(addEmpMenuItem);
    admin.add(addemp);

    JMenu addroom = new JMenu("ADD ROOM");
    JMenuItem addRoomMenuItem = new JMenuItem("Add Room");
    addRoomMenuItem.addActionListener(this);
    addroom.add(addRoomMenuItem);
    admin.add(addroom);
    
    


       JMenu adddrivers =new JMenu("ADD DRIVER");
       JMenuItem adddriversMenuItem = new JMenuItem("Add Driver");
    adddriversMenuItem.addActionListener(this);
    adddrivers.add(adddriversMenuItem);
       admin.add(adddrivers);
       

       
        setVisible(true);


    }
    
    
    @Override
public void actionPerformed(ActionEvent ae) {
    String actionCommand = ae.getActionCommand();
    if (actionCommand.equals("Add Employee")) {
        new AddEmployee();
    } else if (actionCommand.equals("Add Room")) {
        new AddRooms();
    }
    else if (actionCommand.equals("Add Driver")) {
        new AddDriver();
    }
    else if (actionCommand.equals("RECEPTION")) {
        new Reception();
    }
}

     public static void main(String[] args) {
        new Dashboard();
     }

    

   
    }




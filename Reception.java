package HOTELMANGEMENTSYSTEM1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener{
   JButton newCustomer , rooms ,dept , info,minfo,check,emp,upStatus,uproom,pickup,search,logout;
    Reception(){
        getContentPane().setBackground(Color.WHITE);
         newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(10,30,200,30);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.addActionListener(this);
        add(newCustomer);
        
         rooms = new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
        rooms.setForeground(Color.WHITE);
        rooms.setBackground(Color.BLACK);
        rooms.addActionListener(this);
        add(rooms);
        
         dept = new JButton("Department");
        dept.setBounds(10,110,200,30);
        dept.setForeground(Color.WHITE);
        dept.setBackground(Color.BLACK);
        dept.addActionListener(this);
        add(dept);
        
         info = new JButton("Customer Info");
        info.setBounds(10,150,200,30);
        info.setForeground(Color.WHITE);
        info.setBackground(Color.BLACK);
         info.addActionListener(this);
        add(info);
        
         minfo = new JButton("Manager Info");
        minfo.setBounds(10,190,200,30);
        minfo.setForeground(Color.WHITE);
        minfo.setBackground(Color.BLACK);
        minfo.addActionListener(this);
        add(minfo);
        
         check = new JButton("Checkout");
        check.setBounds(10,230,200,30);
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        check.addActionListener(this);
        add(check);
        
         upStatus = new JButton("Update Status");
        upStatus.setBounds(10,270,200,30);
        upStatus.setForeground(Color.WHITE);
        upStatus.setBackground(Color.BLACK);
        
         upStatus.addActionListener(this);
        
        add(upStatus);
        
         uproom = new JButton("Update Room Status");
        uproom.setBounds(10,310,200,30);
        uproom.setForeground(Color.WHITE);
        uproom.setBackground(Color.BLACK);
        uproom.addActionListener(this);
        add(uproom);
        
         pickup= new JButton("Pickup Service");
        pickup.setBounds(10,350,200,30);
        pickup.setForeground(Color.WHITE);
        pickup.setBackground(Color.BLACK);
        pickup.addActionListener(this);
        add(pickup);
        
         search = new JButton("Search Room");
        search.setBounds(10,390,200,30);
        search.setForeground(Color.WHITE);
        search.setBackground(Color.BLACK);
        search.addActionListener(this);
        add(search);
        
        emp = new JButton("All Employees");
        emp.setBounds(10,430,200,30);
        emp.setForeground(Color.WHITE);
        emp.setBackground(Color.BLACK);
        emp.addActionListener(this);
        add(emp);
         logout = new JButton("Logout");
        logout.setBounds(10,470,200,30);
        logout.setForeground(Color.WHITE);
        logout.setBackground(Color.BLACK);
        add(logout);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/fourth.jpg"));
  
     JLabel image = new JLabel(i1);
     image.setBounds(250,30,500,470);
     add(image);
        setLayout(null);
        setBounds(350,200,800,570);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == newCustomer){
        setVisible(false);
        new AddCustomer();
    }
        if(ae.getSource() == rooms){
        setVisible(false);
        new Room();
    }
       else if(ae.getSource() == dept){
        setVisible(false);
        new Department();
    }
        
        else if(ae.getSource() == emp){
        setVisible(false);
        new EmployeeInfo();
    }
        
        else if(ae.getSource() == minfo){
        setVisible(false);
        new ManagerInfo();
    }
        
         
        else if(ae.getSource() == info){
        setVisible(false);
        new CustomerInfo();
    }
        
        else if(ae.getSource() == search){
        setVisible(false);
        new SearchRoom();
    }
         else if(ae.getSource() == uproom){
        setVisible(false);
        new UpdateRoom();
    }
         else if(ae.getSource()== upStatus){
             setVisible(false);
             new UpdateCheck();
     }
         else if(ae.getSource()==pickup){
             setVisible(false);
             new Pickup();
         }
         else if(ae.getSource() == check){
             setVisible(false);
             new CheckOut();
         }
        
        
    }
    public static void main(String[] args) {
        new Reception();
    }
            
}




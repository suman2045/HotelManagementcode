package HOTELMANGEMENTSYSTEM1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class Pickup extends JFrame implements ActionListener{
    JTable table;
    JButton back , btnSearch;
   Choice typeofcar;
   
    JCheckBox available;
    
    Pickup(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel text =new JLabel("Pickup Service");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);
        
        JLabel lblcar=new JLabel("TypeOfCar");
        lblcar.setFont(new Font("Tahoma",Font.PLAIN,20));
        lblcar.setBounds(50,100,100,22);
        add(lblcar);
        
        typeofcar = new Choice();
        typeofcar.setBounds(150,100,200,25);
        add(typeofcar);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from adddriver");
            while (rs.next()){
                typeofcar.add(rs.getString("brand"));
            }
            
            
        } catch(Exception e){
            e.printStackTrace();
        }
          JLabel l1 = new JLabel("Name");
        l1.setBounds(50, 160, 100, 20);
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(160, 160, 100, 20);
        add(l2);
        
        JLabel l3  = new JLabel("Availability");
        l3.setBounds(290, 160, 100, 20);
        add(l3);
        
        JLabel l4 = new JLabel("Gender");
        l4.setBounds(470, 160, 100, 20);
        add(l4);
        
        JLabel l5 = new JLabel("CarCompany");
        l5.setBounds(590, 160, 100, 20);
        add(l5);
        
        JLabel l6 = new JLabel("Location");
        l6.setBounds(720, 160, 100, 20);
        add(l6);
        
        JLabel l7 = new JLabel("Brand");
        l7.setBounds(860, 160, 100, 20);
        add(l7);
        
        
        
        table =new JTable();
        table.setBounds(0, 200, 1000, 300);
        add(table);
        
       try {
           Conn c =  new Conn();
           ResultSet rs = c.s.executeQuery("select * from adddriver");
           table.setModel(DbUtils.resultSetToTableModel(rs));
       }catch(Exception e){
           e.printStackTrace();
       }
        back= new JButton("Back");
    back.setForeground(Color.WHITE);
    back.setBackground(Color.BLACK);
    back.setBounds(500, 520, 120, 30);
    back.addActionListener(this);
    add(back);
        btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SQL = "select * from adddriver where brand = '"+ typeofcar.getSelectedItem()+"'";
				//String SQL2 = "select * from adddriver where availability = 'Available' AND type = '"+ typeofcar.getSelectedItem()+"'";
			try{			
                                Conn c = new Conn();
			ResultSet rs = c.s.executeQuery(SQL);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				
				
			}catch (SQLException ae)
			{
				ae.printStackTrace();
			}
			
			}
		});
		btnSearch.setBounds(300, 520, 120, 30);
                btnSearch.setBackground(Color.BLACK);
                btnSearch.setForeground(Color.WHITE);
		add(btnSearch);
		
      
        
        
        setBounds(300,200,1050,650);
        setVisible(true);
       
    
    
   
    
    }
     
     
    public static void main(String[] args) {
        new Pickup();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();
    }

}

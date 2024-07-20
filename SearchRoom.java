
package HOTELMANGEMENTSYSTEM1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class SearchRoom extends JFrame implements ActionListener{
    JTable table;
    JButton back , btnSearch;
    JComboBox bedType;
    JCheckBox available;
    
    SearchRoom(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel text =new JLabel("Search for Room");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);
        
        JLabel lblbed =new JLabel("Bed Type");
        lblbed.setFont(new Font("Tahoma",Font.PLAIN,20));
        lblbed.setBounds(50,100,100,30);
        add(lblbed);
        bedType = new JComboBox(new String[]{"Single Bed","Double Bed"});
        bedType.setBounds(150, 100, 150, 25);
        bedType.setBackground(Color.WHITE);
        add(bedType);
        
        available = new JCheckBox("Only display Available");
        available.setBounds(650,100,150,25);
        available.setBackground( Color.WHITE);
        add(available);
        
        
        
        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(23, 162, 96, 14);
        add(l1);
        
        JLabel l2 = new JLabel("Availiblity");
        l2.setBounds(175, 162, 120, 14);
        add(l2);
        
        JLabel l3  = new JLabel("Status");
        l3.setBounds(306, 162, 96, 14);
        add(l3);
        
        JLabel l4 = new JLabel("price");
        l4.setBounds(458, 162, 46, 14);
        add(l4);
        
        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(580, 162, 96, 14);
        add(l5);
        
        
        
        
        
        table =new JTable();
        table.setBounds(0, 187, 700, 300);
        add(table);
        
       try {
           Conn c =  new Conn();
           ResultSet rs = c.s.executeQuery("select * from addroom");
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
				String SQL = "select * from addroom where type = '"+bedType.getSelectedItem()+"'";
				String SQL2 = "select * from addroom where availability = 'Available' AND type = '"+ bedType.getSelectedItem()+"'";
			try{			
                                Conn c = new Conn();
			ResultSet rs = c.s.executeQuery(SQL);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				if(available.isSelected())
				{	
					rs = c.s.executeQuery(SQL2);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				
				
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
		
        
        
        
        setBounds(300,200,1050,600);
        setVisible(true);
        
    
    
   
    
    }
     
     
    public static void main(String[] args) {
        new SearchRoom();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Reception();
    }

}

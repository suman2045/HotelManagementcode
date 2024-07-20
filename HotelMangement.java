package HOTELMANGEMENTSYSTEM1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//import com.sun.prism.paint.Color;

public  class HotelMangement extends JFrame implements ActionListener{
    
    HotelMangement(){
        setSize(1366,565);
       // setLocation(100,100);//with respect to screen
       setLayout(null);
        final ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/first.jpg"));
        JLabel image =new JLabel(i1);
        image.setBounds(0,0,1306,566);
        add(image);
        JLabel text =new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20,430,1000,90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.PLAIN,50));
        image.add(text);

        JButton next = new JButton("NEXT");
        next.setBounds(1150,450,150,50);
        next.addActionListener(this);
        
        next.setBackground(Color.WHITE);


        image.add(next);



        setVisible(true);
        while (true)
        {
            text.setVisible(false);
           try{
            Thread.sleep(500);

           }catch(Exception e) {
            e.printStackTrace();
           }
           text.setVisible(true);
           try{
            Thread.sleep(500);

           }catch(Exception e) {
            e.printStackTrace();
           }
        }
        


    }

    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Login();
//event open krne ke liye kya open hona chahiye

    }
    public static void main(String[] args) {
        new HotelMangement();

        
    }

}


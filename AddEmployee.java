package HOTELMANGEMENTSYSTEM1;

//import javax.print.DocFlavor.STRING;

import HOTELMANGEMENTSYSTEM1.Conn;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {

    static void addActionListener(Dashboard aThis) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    JTextField tfname, tfemail, tFphn, tfage, tfsal;
    JRadioButton rbmale, rbfemale;
    JButton submit;
  //  @SuppressWarnings("rawtypes")
    JComboBox cbjob;
    //private PopupMenu cbjobtfname;

    AddEmployee() {
        setLayout(null);

        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 30, 120, 30);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblname);

         tfname = new JTextField();
        tfname.setBounds(200, 30, 150, 30);
        add(tfname);

        JLabel lblage = new JLabel("AGE");
        lblage.setBounds(60, 80, 120, 30);
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200, 80, 150, 30);
        add(tfage);

        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(60, 130, 120, 30);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblgender);

        rbmale = new JRadioButton("MALE");
        rbmale.setBounds(200, 130, 70, 30);
        rbmale.setFont(new Font("Tahoma", Font.PLAIN, 12));
        rbmale.setBackground(Color.WHITE);

        add(rbmale);

        rbfemale = new JRadioButton("FEMALE");
        rbfemale.setBounds(280, 130, 70, 30);
        rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 12));
        rbfemale.setBackground(Color.WHITE);

        add(rbfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        JLabel lbljob = new JLabel("JOB");
        lbljob.setBounds(60, 180, 120, 30);
        lbljob.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbljob);
        String str[] = { "Front Desk CLerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Chefs",
                "Waiter/Witress", "Manager", "Accountant" };
        // @SuppressWarnings("rawtypes")
        cbjob = new JComboBox<>(str);
        cbjob.setBounds(200, 180, 150, 30);
        cbjob.setBackground(Color.WHITE);
        add(cbjob);

        JLabel lblSAL = new JLabel("SALARY");
        lblSAL.setBounds(60, 230, 120, 30);
        lblSAL.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblSAL);

      tfsal = new JTextField();
        tfsal.setBounds(200, 230, 150, 30);
        add(tfsal);

        JLabel lblphone = new JLabel("PHONE");
        lblphone.setBounds(60, 280, 120, 30);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblphone);

        tFphn = new JTextField();
        tFphn.setBounds(200, 280, 150, 30);
        add(tFphn);

        JLabel lblemail = new JLabel("EMAIL");
        lblemail.setBounds(60, 330, 120, 30);
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 330, 150, 30);
        add(tfemail);

        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200, 400, 150, 30);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 60, 360, 350);
        add(image);

        getContentPane().setBackground(Color.WHITE);

        setBounds(350, 200, 850, 540);
        setVisible(true);

    }

      // Next.addActionListener( new ActionListen(){
    //@Override
    @Override
    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsal.getText();
        String phone = tFphn.getText();
        String email = tfemail.getText();
        // String aadhar = tfaadhar.getText();

        String gender = null;

        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Name should not be empty");
            return;
        }

        if (rbmale.isSelected()) {
            gender = "Male";

        } else if (rbfemale.isSelected()) {
            gender = "Female";
        }

        String job = (String) cbjob.getSelectedItem();
        try {

            Conn conn = new Conn();

            System.out.println("code reached");
            String str = "insert into employee values('" + name + "','" + age + "','" + gender + "','" + job + "','"
                    + salary + " ','" + phone + " ','" + email + " ')";
             conn.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null, "Employee added successfully");
            this.setVisible(false);

        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}

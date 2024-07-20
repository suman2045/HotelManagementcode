/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HOTELMANGEMENTSYSTEM1;

/**
 *
 * @author suman
 */
import java.sql.*;
//library for sql

public class Conn {

    Connection c; //creating the connection with sql //connection is object for sql
    Statement s; //create statement 
    Object Conn;

    public Conn() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver"); //forname is static method //com.mysql.........Driver is Driver name;
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "system");
            // for Connection string we use DriverManger class  and getConnection is a function and under bracket isa connection string
            s = c.createStatement();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

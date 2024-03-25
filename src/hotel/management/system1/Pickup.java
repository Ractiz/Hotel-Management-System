


package hotel.management.system1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Pickup extends JFrame implements ActionListener{
    JTable table;
    JButton back; 
    Pickup(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(10,10,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(160,10,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(340,10,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Company");
        l4.setBounds(480,10,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Brand");
        l5.setBounds(620,10,100,20);
        add(l5);
        
        JLabel l6 = new JLabel("Availability");
        l6.setBounds(740,10,100,20);
        add(l6);
        
        JLabel l7 = new JLabel("Address");
        l7.setBounds(900,10,100,20);
        add(l7);
        
        table = new JTable();
        table.setBounds(0,40,1000,400);
        add(table);
        
        try{
            Conn c= new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        back =new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(420,500,120,30);
        add(back);
        
        setBounds(150,50,1000,600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    
    public static void main(String[] args){
        new Pickup();
    } 
}



package hotel.management.system1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener{
    JButton newCustomer,rooms,allEmployee,customers,pickup,checkout,logout;
    Reception() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(10,50,200,30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setBackground(Color.WHITE);
        newCustomer.addActionListener(this);
        add(newCustomer);
        
        rooms = new JButton("Rooms");
        rooms.setBounds(10,90,200,30);
        rooms.setBackground(Color.BLACK);
        rooms.setBackground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);
        
        allEmployee = new JButton("All Employees");
        allEmployee.setBounds(10,130,200,30);
        allEmployee.setBackground(Color.BLACK);
        allEmployee.setBackground(Color.WHITE);
        allEmployee.addActionListener(this);
        add(allEmployee);
        
        customers = new JButton("Customer Info");
        customers.setBounds(10,170,200,30);
        customers.setBackground(Color.BLACK);
        customers.setBackground(Color.WHITE);
        customers.addActionListener(this);
        add(customers);
        
        pickup = new JButton("Pickup Services");
        pickup.setBounds(10,210,200,30);
        pickup.setBackground(Color.BLACK);
        pickup.setBackground(Color.WHITE);
        pickup.addActionListener(this);
        add(pickup);
        
        checkout = new JButton("Checkout");
        checkout.setBounds(10,250,200,30);
        checkout.setBackground(Color.BLACK);
        checkout.setBackground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);
        
        logout = new JButton("Log Out");
        logout.setBounds(10,290,200,30);
        logout.setBackground(Color.BLACK);
        logout.setBackground(Color.WHITE);
        logout.addActionListener(this);

        add(logout);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(90,30,500,470);
        add(image);
        
        setBounds(300,100,600,400);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == newCustomer){
            setVisible(false);
            new AddCustomer();
        } else if (ae.getSource() == rooms) {
        setVisible(false);
        new Room();
        }else if(ae.getSource() == allEmployee){
            setVisible(false);
            new EmployeeInfo();
        } else if(ae.getSource() == customers){
            setVisible(false);
            new CustomerInfo();
        } else if(ae.getSource() == pickup){
            setVisible(false);
            new Pickup();
        } else if(ae.getSource() == checkout){
            setVisible(false);
            new Checkout();
        }else if (ae.getSource() == logout)
        {
            setVisible(false);
            System.exit(0);
        }
    }
    
    public static void main(String[] args){
        new Reception();
    }
}

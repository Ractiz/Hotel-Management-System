
package hotel.management.system1;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JComboBox comboid;
    JTextField tfnumber,tfname,tfcountry,tfdeposit;
    JRadioButton rmale,rfemale;
    Choice croom;
    JButton add,back;
    
    AddCustomer() {
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("New Customer Form");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Railway",Font.PLAIN,20));
        add(text);
        
        JLabel iblid = new JLabel("ID");
        iblid.setBounds(35,80,100,20);
        iblid.setFont(new Font("Railway",Font.PLAIN,20));
        add(iblid);
        
        String options[]={"Adhar Card", "Passport", "Driving Licence", "Voter-id card"};
        comboid = new JComboBox(options);
        comboid.setBounds(200,80,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
        JLabel iblnumber = new JLabel("Number");
        iblnumber.setBounds(35,120,100,20);
        iblnumber.setFont(new Font("Railway",Font.PLAIN,20));
        add(iblnumber);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(200,120,150,25);
        add(tfnumber);
        
        JLabel iblname = new JLabel("Name");
        iblname.setBounds(35,160,100,20);
        iblname.setFont(new Font("Railway",Font.PLAIN,20));
        add(iblname);
        
        tfname = new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);
        
        JLabel iblgender = new JLabel("Gender");
        iblgender.setBounds(35,200,100,20);
        iblgender.setFont(new Font("Railway",Font.PLAIN,20));
        add(iblgender);
        
        rmale = new JRadioButton("Male");
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(200,200,60,25);
        add(rmale);
        
        rfemale = new JRadioButton("Female");
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(270,200,100,25);
        add(rfemale);
        
        JLabel iblcountry = new JLabel("Country");
        iblcountry.setBounds(35,240,100,20);
        iblcountry.setFont(new Font("Railway",Font.PLAIN,20));
        add(iblcountry);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);
        
        JLabel iblroom = new JLabel("Room Number");
        iblroom.setBounds(35,280,150,20);
        iblroom.setFont(new Font("Railway",Font.PLAIN,20));
        add(iblroom);
        
        croom = new Choice();
        
        try {
            Conn conn = new Conn();
            String query = "select * from room where availability = 'Available'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getString("roomnumber"));
            }
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        croom.setBounds(200,280,150,25);
        add(croom);
        
        JLabel lbldeposit = new JLabel("Deposit");
        lbldeposit.setBounds(35,320,100,20);
        lbldeposit.setFont(new Font("Railway",Font.PLAIN,20));
        add(lbldeposit);
        
        tfdeposit = new JTextField();
        tfdeposit.setBounds(200,320,150,25);
        add(tfdeposit);
        
        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(50,360,120,30);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,360,120,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2=i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);
        
        setBounds(200,100,800,550);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add) {
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = null;
            
            if(rmale.isSelected()){
                gender="Male";
            }else{
                gender="Female";
            }
        String country = tfcountry.getText();
        String room = croom.getSelectedItem();
        String deposit=tfdeposit.getText();
        
        try {
            String query = "insert into customer values('"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+room+"', '"+deposit+"')";
            String query2 = "update room set availability = 'Occupied' where roomnumber = '"+room+"'";
            
            Conn conn = new Conn();
            
            conn.s.executeUpdate(query);
            conn.s.executeUpdate(query2);
            
            JOptionPane.showMessageDialog(null,"New Customer Added Successfully");
            
            setVisible(false);
            new Reception();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        } else if(ae.getSource() == back){
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args){
        new AddCustomer();
    }
}

package placement.management.system;

import java.awt.*;
import javax.swing.*;
//import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class AddStudent extends JFrame implements ActionListener{
    
    JTextField tfname,tfUSN,tfmail,tfcgpa,tfphone,tfaddress;
    //JDateChooser dcdob
    JButton add,back;
    AddStudent(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Student Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
       
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
        
        JLabel labelUSN = new JLabel("USN");
        labelUSN.setBounds(400, 150, 150, 30);
        labelUSN.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelUSN);
        
        tfUSN = new JTextField();
        tfUSN.setBounds(600,150,150,30);
        add(tfUSN);
        
        
//        JLabel labeldob =new JLabel("Date");
//        labeldob.setBounds(50,200,150,30);
//        labeldob.setFont(new Font("serif",Font.PLAIN,20));
//        add(dcdob);
//        
//        
//        JDateChooser dcdob = new JDateChooser();
//        dcdob.setBounds(200,200,150,30);
//        add(dcdob);
        
        
        JLabel labelmail = new JLabel("Email");
        labelmail.setBounds(50, 200, 150, 30);
        labelmail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelmail);
        
        tfmail = new JTextField();
        tfmail.setBounds(200,200,150,30);
        add(tfmail);
        
        
        JLabel labelcgpa = new JLabel("CGPA");
        labelcgpa.setBounds(400, 200, 150, 30);
        labelcgpa.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelcgpa);
        
        tfcgpa = new JTextField();
        tfcgpa.setBounds(600,200,150,30);
        add(tfcgpa);
        
        
        JLabel labelphone = new JLabel("Phone Number");
        labelphone.setBounds(50, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(200,250,150,30);
        add(tfphone);
        
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(400, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(600,250,150,30);
        add(tfaddress);
        
        add= new JButton("Add Details");
        add.setBounds(250,350,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450,350,150,40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== add){
            String name=tfname.getText();
            String USN=tfUSN.getText();
            String email=tfmail.getText();
            String Phone=tfphone.getText();
            String cgpa=tfcgpa.getText();
            String address=tfaddress.getText();
            //String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            
            try {
//                String username=tfusername.getText();
//                Sring password=tfpassword.getText();
                
                Conn conn = new Conn();
                String query = "insert into student values('"+name+"', '"+USN+"', '"+email+"', '"+Phone+"', '"+cgpa+"', '"+address+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Faculty();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
            new Faculty();
        }
    }
    
    public static void main(String[] args){
        new AddStudent();
    }
    
}

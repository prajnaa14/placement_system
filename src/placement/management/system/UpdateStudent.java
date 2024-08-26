package placement.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStudent extends JFrame implements ActionListener{
    
    JTextField  tfname, tfaddress, tfphone, tfUSN, tfmail,tfcgpa;
    JLabel lblUSN;
    JButton add, back;
    String USN;
    
    UpdateStudent(String USN) {
        this.USN = USN;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Student Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        add(lblname);
        
        
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
        
        
        JLabel labelphone = new JLabel("Phone");
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
        
        

        
        JLabel labelUSN = new JLabel("USN");
        labelUSN.setBounds(400, 150, 150, 30);
        labelUSN.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelUSN);
        
        lblUSN = new JLabel();
        lblUSN.setBounds(600,150,150,30);
        lblUSN.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblUSN);
        
        try {
            Conn c = new Conn();
            String query = "select * from student where USN = '" + USN + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblname.setText(rs.getString("name"));
                lblUSN.setText(rs.getString("USN"));
                tfmail.setText(rs.getString("email"));
                tfcgpa.setText(rs.getString("CGPA"));
                tfphone.setText(rs.getString("phone"));
                tfaddress.setText(rs.getString("address"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
//        JLabel labeldob = new JLabel("Date of Birth");
//        labeldob.setBounds(50, 200, 150, 30);
//        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
//        add(labeldob);
        
//        JLabel lbldob = new JLabel();
//        lbldob.setBounds(200, 200, 150, 30);
//        add(lbldob);
        

        add = new JButton("Update Details");
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
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String email = tfmail.getText();
            String cgpa = tfcgpa.getText();
            String phone = tfphone.getText();
            String address = tfaddress.getText();

            try {
                Conn conn = new Conn();
                String query = "update student set email = '" + email + "', cgpa = '" + cgpa + "', phone = '" + phone + "', address =  '" + address + "' where USN = '" + USN + "'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Faculty();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Faculty();
        }
    }


    public static void main(String[] args) {
        new UpdateStudent("");
    }
}
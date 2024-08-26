package placement.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateFaculty extends JFrame implements ActionListener{
    
    JTextField  tfid, tffname, tfsubject, tfdesignation;
    JLabel lblfid;
    JButton add, back;
    String fid;
    
    UpdateFaculty(String fid) {
        this.fid = fid;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Faculty Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labelfname = new JLabel("fname");
        labelfname.setBounds(50, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
        
        JLabel lblfname = new JLabel();
        lblfname.setBounds(200, 150, 150, 30);
        add(lblfname);
        
        
        JLabel labelsubject = new JLabel("Subject");
        labelsubject.setBounds(50, 200, 150, 30);
        labelsubject.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsubject);
        
        tfsubject = new JTextField();
        tfsubject.setBounds(200,200,150,30);
        add(tfsubject);
        
        
        JLabel labeldesignation = new JLabel("designation");
        labeldesignation.setBounds(400, 200, 150, 30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);
        
        tfdesignation = new JTextField();
        tfdesignation.setBounds(600,200,150,30);
        add(tfdesignation);
        
        

        
        JLabel labelfid = new JLabel("fid");
        labelfid.setBounds(400, 150, 150, 30);
        labelfid.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfid);
        
        lblfid = new JLabel();
        lblfid.setBounds(600,150,150,30);
        lblfid.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblfid);
        
        try {
            Conn c = new Conn();
            String query = "select * from faculty where fid = '" + fid + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblfid.setText(rs.getString("fid"));
                lblfname.setText(rs.getString("fname"));
                tfsubject.setText(rs.getString("subject"));
                tfdesignation.setText(rs.getString("designation"));
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
        add.setBounds(250,270,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450,270,150,40);
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
        String subject = tfsubject.getText();
        String designation = tfdesignation.getText();
        try {
            Conn conn = new Conn();
            String query = "update faculty set subject = '" + subject + "', designation = '" + designation + "'where fid = '" + fid + "'";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Details updated successfully");
            setVisible(false);
            // Assuming FacultyDashboard is the correct class for the Faculty dashboard
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
        new UpdateFaculty("");
    }
}
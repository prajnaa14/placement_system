package placement.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateSStatus extends JFrame implements ActionListener{
    
    JTextField  tfino, tfstatus, tfUSN;
    JLabel lblUSN,lblino;
    JButton add, back;
    String USN;
    
    UpdateSStatus(String USN) {
        this.USN = USN;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Student Status");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel labelUSN = new JLabel("USN");
        labelUSN.setBounds(50, 150, 150, 30);
        labelUSN.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelUSN);
        
        JLabel lblUSN = new JLabel();
        lblUSN.setBounds(200, 150, 150, 30);
        add(lblUSN);
        
        
        JLabel labelino = new JLabel("Interview-no");
        labelino.setBounds(400, 150, 150, 30);
        labelino.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelino);
        
        lblino = new JLabel();
        lblino.setBounds(600,150,150,30);
        lblino.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblino);
        
        
       
        JLabel labelstatus = new JLabel("Status");
        labelstatus.setBounds(400, 200, 150, 30);
        labelstatus.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelstatus);
        
        tfstatus = new JTextField();
        tfstatus.setBounds(600,200,150,30);
        add(tfstatus);
        
        
    
        try {
            Conn c = new Conn();
            String query = "select * from status where USN = '" + USN + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblUSN.setText(rs.getString("USN"));
                lblino.setText(rs.getString("ino"));
                tfstatus.setText(rs.getString("Status"));
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
            String status = tfstatus.getText();

            try {
                Conn conn = new Conn();
                String query = "update status set status = '" + status + "' where USN = '" + USN + "'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Student();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Student();
        }
    }


    public static void main(String[] args) {
        new UpdateSStatus("");
    }
}
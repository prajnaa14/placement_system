package placement.management.system;

import java.awt.*;
import javax.swing.*;
//import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddCompany extends JFrame implements ActionListener{
    
    JTextField tfname,tfbranch,tfposition,tfpackage;
    //JDateChooser dcdob
    JButton add,back;
    AddCompany(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Company Details");
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
        
        
        JLabel labelbranch = new JLabel("Branch");
        labelbranch.setBounds(400, 150, 150, 30);
        labelbranch.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelbranch);
        
        tfbranch = new JTextField();
        tfbranch.setBounds(600,150,150,30);
        add(tfbranch);
        
        
//        JLabel labeldob =new JLabel("Date");
//        labeldob.setBounds(50,200,150,30);
//        labeldob.setFont(new Font("serif",Font.PLAIN,20));
//        add(dcdob);
//        
//        
//        JDateChooser dcdob = new JDateChooser();
//        dcdob.setBounds(200,200,150,30);
//        add(dcdob);
        
        
        JLabel labelposition = new JLabel("Position");
        labelposition.setBounds(50, 200, 150, 30);
        labelposition.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelposition);
        
        tfposition = new JTextField();
        tfposition.setBounds(200,200,150,30);
        add(tfposition);
        
        
        JLabel labelpackage = new JLabel("Package");
        labelpackage.setBounds(400, 200, 150, 30);
        labelpackage.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelpackage);
        
        tfpackage = new JTextField();
        tfpackage.setBounds(600,200,150,30);
        add(tfpackage);
        
       
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
            String branch=tfbranch.getText();
            String position=tfposition.getText();
            String packageValue=tfpackage.getText();
            //String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            
            try {
//                String username=tfusername.getText();
//                Sring password=tfpassword.getText();
                
                Conn conn = new Conn();
                String query = "insert into company (cname, branch, position, package) values('"+name+"', '"+branch+"', '"+position+"', '"+packageValue+"')";
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
        new AddCompany();
    }
    
}
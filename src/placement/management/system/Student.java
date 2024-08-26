package placement.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Student extends JFrame implements ActionListener{
      JButton updateSStudent,viewStudent,viewCompany,viewInterview,updateInterview,viewStatus, backButton;
    Student() {
       
        setLayout(null);  
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/remove.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);
        
        JLabel heading = new JLabel("Placement Management System");
        heading.setBounds(200, 20, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(heading);
        
        updateSStudent = new JButton("Update Student");
        updateSStudent.setBounds(200, 80, 150, 40);
        updateSStudent.addActionListener(this); // Fixed: updateStudent instead of update
        image.add(updateSStudent);

        viewStudent = new JButton("View Student");
        viewStudent.setBounds(400, 80, 150, 40);
        viewStudent.addActionListener(this); // Fixed: viewStudent instead of view
        image.add(viewStudent);

        viewCompany = new JButton("View Company");
        viewCompany.setBounds(600, 80, 150, 40); 
        viewCompany.addActionListener(this); // Fixed: viewCompany instead of view
        image.add(viewCompany);

        viewInterview = new JButton("View Interview");
        viewInterview.setBounds(400, 150, 150, 40); 
        viewInterview.addActionListener(this); // Fixed: viewInterview instead of view
        image.add(viewInterview);
        
        viewStatus = new JButton("View Status");
        viewStatus.setBounds(600, 150, 150, 40); 
        viewStatus.addActionListener(this); // Fixed: viewInterview instead of view
        image.add(viewStatus);
        

        updateInterview = new JButton("Update I-Status");
        updateInterview.setBounds(200, 150, 150, 40); 
        updateInterview.addActionListener(this); // Fixed: updateInterview instead of update
        image.add(updateInterview);
        
        
        
        backButton = new JButton("Back");
        backButton.setBounds(800, 20, 80, 30);
        backButton.addActionListener(this);
        image.add(backButton);



        setSize(1200,630);
        setLocation(250,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
         if (ae.getSource() == updateSStudent) {
           setVisible(false);
           new ViewSStudent();
        } else if (ae.getSource() == viewStudent) {
           setVisible(false);
           new ViewSStudent();
        } else if (ae.getSource() == viewCompany) {
           setVisible(false);
           new ViewSCompany();
        }else if (ae.getSource() == viewInterview) {
           setVisible(false);
           new ViewSInterview();
        }else if (ae.getSource() == viewStatus) {
           setVisible(false);
           new ViewSStatus();
        }else if (ae.getSource() == backButton) {
            setVisible(false);
            new Login();
        }else {
           setVisible(false);
           new ViewSStatus();
        }
    }

    public static void main(String[] args) {
        new Student();
    }
}
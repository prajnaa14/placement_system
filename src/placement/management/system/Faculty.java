package placement.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Faculty extends JFrame implements ActionListener{
      JButton  backButton,addStudent,addcompany,deleteStudent,updateStudent,viewStudent,viewFaculty,updateFaculty,viewCompany,viewInterview,viewStatus;
    Faculty() {
       
        setLayout(null);  
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/stdpl.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);
        
        JLabel heading = new JLabel("Placement Management System");
        heading.setBounds(200, 20, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(heading);
        
        addStudent = new JButton("Add Student");
        addStudent.setBounds(200, 80, 150, 40);
        addStudent.addActionListener(this); // Fixed: updateStudent instead of update
        image.add(addStudent);
        
        deleteStudent = new JButton("Delete Student");
        deleteStudent.setBounds(400, 80, 150, 40);
        deleteStudent.addActionListener(this); // Fixed: updateStudent instead of update
        image.add(deleteStudent);

        viewStudent = new JButton("View Student");
        viewStudent.setBounds(580, 80, 150, 40);
        viewStudent.addActionListener(this); // Fixed: viewStudent instead of view
        image.add(viewStudent);

        viewCompany = new JButton("View Company");
        viewCompany.setBounds(200, 220, 150, 40); 
        viewCompany.addActionListener(this); // Fixed: viewCompany instead of view
        image.add(viewCompany);
        
        viewStatus = new JButton("View Status");
        viewStatus.setBounds(580, 150, 150, 40); 
        viewStatus.addActionListener(this); // Fixed: viewCompany instead of view
        image.add(viewStatus);
        
        viewFaculty = new JButton("View Faculty");
        viewFaculty.setBounds(395, 220, 150, 40); 
        viewFaculty.addActionListener(this); // Fixed: viewCompany instead of view
        image.add(viewFaculty);
        
        updateFaculty = new JButton("Update Faculty");
        updateFaculty.setBounds(200, 150, 150, 40); 
        updateFaculty.addActionListener(this); // Fixed: updateInterview instead of update
        image.add(updateFaculty);
        
        viewInterview = new JButton("View Interview");
        viewInterview.setBounds(580, 220, 150, 40); 
        viewInterview.addActionListener(this); // Fixed: viewInterview instead of view
        image.add(viewInterview);

        updateStudent = new JButton("Update Student");
        updateStudent.setBounds(400, 150, 150, 40); 
        updateStudent.addActionListener(this); // Fixed: updateInterview instead of update
        image.add(updateStudent);
        
        addcompany = new JButton("Add Company");
        addcompany.setBounds(200,   290, 150, 40); 
        addcompany.addActionListener(this); // Fixed: updateInterview instead of update
        image.add(addcompany);
        
        
        backButton = new JButton("Back");
        backButton.setBounds(800, 20, 80, 30);
        backButton.addActionListener(this);
        image.add(backButton);

        

        setSize(1200,630);
        setLocation(250,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
         if (ae.getSource() == addStudent) {
           setVisible(false);
           new AddStudent();
        } else if (ae.getSource() == deleteStudent) {
            setVisible(false);
           new DeleteStudent();
        } else if (ae.getSource() == viewStudent) {
           setVisible(false);
           new ViewStudent();
        }else if (ae.getSource() == viewCompany) {
           setVisible(false);
           new ViewCompany();
        }else if (ae.getSource() == addcompany) {
           setVisible(false);
           new AddCompany();
        }else if (ae.getSource() == viewStatus) {
            setVisible(false);
           new ViewStatus();
        }else if (ae.getSource() == viewFaculty) {
           setVisible(false);
           new ViewFaculty();
        }else if (ae.getSource() == updateFaculty) {
           setVisible(false);
           new ViewFaculty();
        }else if (ae.getSource() == viewInterview) {
           setVisible(false);
           new ViewInterview();
        }else if (ae.getSource() == backButton) {
            setVisible(false);
            new Login();
        }else {
           setVisible(false);
           new ViewStudent();
        }
    }

    public static void main(String[] args) {
        new Faculty();
    }
}
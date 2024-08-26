package placement.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField tfusername, tfpassword;
    JComboBox<String> roleDropdown;

    Login() {

        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 30);
        lblusername.setForeground(Color.WHITE);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 30);
        add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 30);
        lblpassword.setForeground(Color.WHITE);
        add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(150, 70, 150, 30);
        add(tfpassword);

        JLabel lblrole = new JLabel("Role");
        lblrole.setBounds(40, 120, 100, 30);
        lblrole.setForeground(Color.WHITE);
        add(lblrole);

        String[] roles = {"Faculty", "Student"};
        roleDropdown = new JComboBox<>(roles);
        roleDropdown.setBounds(150, 120, 150, 30);
        add(roleDropdown);

        JButton login = new JButton("LOGIN");
        login.setBounds(150, 170, 150, 30);
        login.setBackground(Color.WHITE);
        login.setForeground(Color.BLACK);
        login.addActionListener(this);
        add(login);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 200, 200);
        add(image);

        setSize(800, 500);
        setLocation(450, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            String role = (String) roleDropdown.getSelectedItem();

            Conn c = new Conn();
            String query = "select * from login where username = '" + username + "' and password = '" + password
                    + "' and role = '" + role + "'";

            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                setVisible(false);
                // Depending on the role, you can redirect to the appropriate page
                if (role.equals("Faculty")) {
                    new Faculty();
                } else if (role.equals("Student")) {
                    new Student();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username, password, or role");
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}

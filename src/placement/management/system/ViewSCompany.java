package placement.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewSCompany extends JFrame implements ActionListener {
    
    JTable table;
    Choice ccid;
    JButton search, print, update, back;
    
    ViewSCompany(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel searchlbl = new JLabel("Search by Company ID");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
        
        ccid = new Choice();
        ccid.setBounds(180, 20, 150, 20);
        add(ccid);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from company");
            while(rs.next()) {
                ccid.add(rs.getString("cid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from company");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
         
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
//        update = new JButton("Update");
//        update.setBounds(220, 70, 80, 20);
//        update.addActionListener(this);
//        add(update);
        
        back = new JButton("Back");
        back.setBounds(220, 70, 80, 20);
        back.addActionListener(this);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == search){
            String query = "select * from company where cid = '"+ccid.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (ae.getSource() == print){
             try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (ae.getSource() == update){
            
        }else{
            setVisible(false);
            new Student();
        }
    }
    
    public static void main(String[] args){
        new ViewSCompany();
    }
}

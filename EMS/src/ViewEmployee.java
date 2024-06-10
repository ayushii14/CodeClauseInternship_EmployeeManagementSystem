package EMS.src;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmployee extends JFrame implements ActionListener{
    
    Choice choiceEMP;
    JTable table;
JButton searchbtn, print, update, back;
    ViewEmployee(){

        getContentPane().setBackground(new Color(255,131,122));
        setLayout(null);

        JLabel search = new JLabel("Search by Employee id");
        search.setBounds(20,20,150,20);
        add(search);

        choiceEMP = new Choice();
        choiceEMP.setBounds(180,20,150,20);
        add(choiceEMP);

        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee2");
            while (resultSet.next()){
                choiceEMP.add(resultSet.getString("empId"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        table = new JTable();
        try{
            Conn c= new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee2");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0,100,900,600);
        add(jp);

        searchbtn = new JButton("Search");
        searchbtn.setBounds(20,70,80,20);
        searchbtn.addActionListener(this);
        add(searchbtn);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
       print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);

     setSize(900,700);
      setLocation(300,100);
     setVisible(true);
     
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchbtn){
            String query = "select * from employee2 where empId = '"+choiceEMP.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try {
                table.print();
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource() == update){
            setVisible(false);
            new UpdateEmployee(choiceEMP.getSelectedItem()); //we get idno. from the search bar we selected on this class
        } else if (e.getSource() == back) {
            setVisible(false);
            new MainClass();
        }
    }
    public static void main(String[] args) {
        new ViewEmployee();
    }
}

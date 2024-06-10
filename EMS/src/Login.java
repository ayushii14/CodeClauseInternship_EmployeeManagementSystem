package EMS.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener  {

   
    JTextField tfusername, tfpassword;
    JButton login,back;

    Login(){
       
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
      

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 30);
        add(lblusername);

        
        //box for writing=textfield
        JTextField tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 30);
        add(tfusername);
       

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 30);
        add(lblpassword);

        JTextField tfpassword = new JTextField();
        tfpassword.setBounds(150, 70, 150, 30);
        add(tfpassword);

        login = new JButton("LOGIN");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
       // login.addActionListener(this);
       login.addActionListener( new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == login){
                try {
                    String username = tfusername.getText();
                    String password = tfpassword.getText();
    
                    Conn c= new Conn();
                    String query = "select * from login where username = '"+ username +"' and password = '"+password+"'";
                    ResultSet resultSet =c.statement.executeQuery(query);
                    if (resultSet.next()){
                        
                        JOptionPane.showMessageDialog(null,"Login Succesfully");
                        setVisible(false);
                       new MainClass();
                    }else {
                        JOptionPane.showMessageDialog(null,"Invalid username or password");
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
    
            } else if (e.getSource() == back) {
                System.exit(90);
            }
         
           // setVisible(false);
        }
    });

          add(login);

      back = new JButton("BACK");
        back.setBounds(150,180,150,30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("EMS/icons/loginpage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 0, 200, 200);
        add(image);
        

        setSize(700,400);
        setLocation(400,200);
        setVisible(true);
        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login){

            try {
                String username = tfusername.getText();
                String password = tfpassword.getText();

                Conn c= new Conn();
                String query = "select * from login where username = '"+ username +"' and password = '"+password+"'";
                ResultSet resultSet =c.statement.executeQuery(query);
                if (resultSet.next()){
                    JOptionPane.showMessageDialog(null,"Login Succesfully");
                    setVisible(false);
                   new MainClass();
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid username or password"); 
                }
            }catch (Exception E){
                E.printStackTrace();
            }

        } else if (e.getSource() == back) {
            System.exit(20);
        }
    }

   public static void main(String[] args) {
    new Login();
   }


}
package EMS.src;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//action listerner is an interface we used it coz we want an event or an action to happen when we click at the button
public class Splash extends JFrame implements ActionListener {

  Splash() {

    getContentPane().setBackground(Color.BLACK);
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


     // imageicon class
    ImageIcon img = new ImageIcon("EMS/icons/background1.jpg");
    Image i1 = img.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
    ImageIcon i2 = new ImageIcon(i1);
    JLabel background = new JLabel(i2);
    background.setBounds(0, 0, 1200, 600);
    getContentPane().add(background, 0);
    setVisible(true);
    // add(background);

    JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
    heading.setBounds(0, 20, 1200, 60);
    heading.setFont(new Font("poppins", Font.BOLD, 40));
    heading.setForeground(Color.pink);
    background.add(heading);

    JButton clickhere = new JButton("Click Here To Continue");
    clickhere.setBounds(20, 400, 300, 70);
    clickhere.setBackground(Color.BLACK);
    clickhere.setForeground(Color.WHITE);
    clickhere.setBorder(null);
    clickhere.addActionListener(this);
    background.add(clickhere); // image ke uper button ko dalna //relative to image

    setSize(1200, 600);
    setLocation(70, 50);
    setVisible(true);

    while (true) {
      heading.setVisible(false);
      try {
        Thread.sleep(1000);
      } catch (Exception e) {

      }

      heading.setVisible(true);
      try {
        Thread.sleep(1000);
      } catch (Exception e) {

      }
    }

  }

  public void actionPerformed(ActionEvent ae) {
    setVisible(false);
    new Login();
  }

  public static void main(String args[]) {
    new Splash();// as soon as we make an object of class a constructor gets called thats why
                 // every time we have to make a constructor so that something or the other
                 // function works
   
  }

}

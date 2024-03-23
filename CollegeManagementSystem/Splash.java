package CollegeManagementSystem;

import java.awt.Image;
import javax.swing.*;


public class Splash extends JFrame implements Runnable {

    Thread t;

    public Splash(){
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("CollegeManagementSystem/icons/main.jpg"));
        Image i2=i1.getImage().getScaledInstance(1500, 800, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);

        t=new Thread(this);
        t.start();

        add(image);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(1500,800);
        setLocation(25,20);
        setVisible(true);
    }


    public void run() {
        try {
            Thread.sleep(3000);
            dispose();

            // Next Frame
            new Login();
        } catch (Exception e) {

        }
    }




    public static void main(String[] args) {
        new Splash();  //anonymous object
    }
}


package CollegeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login,cancel;
    JTextField tfusername,tfpassword;

    Login(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        /*JLabel lblcollege =new JLabel("St. Andrews Institute Of Technology And Management");
        lblcollege.setBounds(500,5,500,100);
        lblcollege.setFont(new Font( "Comic Sans MS",Font.BOLD,18));
        add(lblcollege);*/


        ImageIcon i5=new ImageIcon(ClassLoader.getSystemResource("CollegeManagementSystem/icons/logo.png"));
        Image i6=i5.getImage().getScaledInstance(599, 100, Image.SCALE_SMOOTH);
        ImageIcon i7=new ImageIcon(i6);
        JLabel logo1 = new JLabel(i7);
        logo1.setBounds(345,0,700,200);
        add(logo1);


        JLabel lblusername =new JLabel("Username");
        lblusername.setBounds(675,200,100,20);
        lblusername.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(lblusername);

        tfusername=new JTextField();
        tfusername.setBounds(600, 240,250,50);
        add(tfusername);

        JLabel lblpassword =new JLabel("Password");
        lblpassword.setBounds(675,320,100,20);
        lblpassword.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(lblpassword);

        tfpassword=new JPasswordField();
        tfpassword.setBounds(600, 360,250,50);
        add(tfpassword);

        login=new JButton("Login");
        login.setBounds(580,450,150,40);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setFont(new Font( "Comic Sans MS",Font.BOLD,18));
        login.addActionListener(this);
        add(login);

        cancel=new JButton("Cancel");
        cancel.setBounds(750,450,150,40);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font( "Comic Sans MS",Font.BOLD,18));
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("CollegeManagementSystem/icons/user.jfif"));
        Image i2=i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(1000,225,200,200);
        add(image);



        setSize(1500,800);
        setLocation(25,20);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){

            String username=tfusername.getText();
            String password=tfpassword.getText();

            String query = "SELECT * FROM login WHERE USERNAME='" + username + "' AND PASSWORD='" + password + "'";


            try{

                Conn c=new Conn();
                ResultSet rs=  c.s.executeQuery(query);

                if(rs.next()){
                    dispose();
                    new Project();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                    dispose();
                }

            }catch(Exception e){
                e.printStackTrace();
            }

        }
        else if(ae.getSource()==cancel){
            dispose();
        }

    }

    public static void main(String[] args) {
        new Login();
    }

}
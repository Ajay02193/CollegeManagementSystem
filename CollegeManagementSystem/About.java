package CollegeManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class About extends JFrame implements ActionListener{

    JButton exit;

    About(){
        getContentPane().setBackground(Color.WHITE);
        setSize(1000,600);
        setLocation(250,140);
        setLayout(null);

        ImageIcon i5=new ImageIcon(ClassLoader.getSystemResource("CollegeManagementSystem/icons/logo.png"));
        Image i6=i5.getImage().getScaledInstance(599, 100, Image.SCALE_SMOOTH);
        ImageIcon i7=new ImageIcon(i6);
        JLabel logo1 = new JLabel(i7);
        logo1.setBounds(130,-50,700,200);
        add(logo1);

        JLabel heading = new JLabel("<HTML>College<BR> Management System</HTML>");
        heading.setBounds(100,20,325,500);
        heading.setFont(new Font("Comic Sans MS",Font.BOLD,50));
        add(heading);

        JLabel own=new JLabel("<HTML>Developed by: <BR>Ajay <BR>Kumar<BR> Srivastava</HTML>");
        own.setBounds(625,20,325,500);
        own.setFont(new Font("Comic Sans MS",Font.BOLD,35));
        add(own);

        exit=new JButton("EXIT");
        exit.setBounds(910,0,75,25);
        exit.setFont(new Font("Comic Sans MS",Font.BOLD,12));
        exit.setForeground(Color.RED);
        exit.addActionListener(this);
        add(exit);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit)
            dispose();

    }

    public static void main(String[] args) {
        new About();
    }

}


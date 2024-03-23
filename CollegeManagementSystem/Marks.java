package CollegeManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;
import javax.swing.JButton;


public class Marks extends JFrame implements ActionListener{

    JButton cancel, check, exit;
    String rollno;

    Marks(String rollno){
        getContentPane().setBackground(Color.WHITE);
        setSize(1500,800);
        setLocation(25,20);
        setLayout(null);

        ImageIcon i5=new ImageIcon(ClassLoader.getSystemResource("CollegeManagementSystem/icons/logo.png"));
        Image i6=i5.getImage().getScaledInstance(599, 100, Image.SCALE_SMOOTH);
        ImageIcon i7=new ImageIcon(i6);
        JLabel logo1 = new JLabel(i7);
        logo1.setBounds(345,-50,700,200);
        add(logo1);

        JLabel heading = new JLabel("Result");
        heading.setBounds(675,125,500,50);
        heading.setFont(new Font("Comic Sans MS",Font.BOLD,30));
        add(heading);

        JLabel rolllbl=new JLabel("Roll No");
        rolllbl.setBounds(125,200,200,30);
        rolllbl.setFont(new Font("Comic Sans MS",Font.BOLD,22));
        add(rolllbl);

        JLabel roll=new JLabel();
        roll.setBounds(230,200,200,30);
        roll.setFont(new Font("Comic Sans MS",Font.PLAIN,22));
        add(roll);

        JLabel courselbl=new JLabel("Course");
        courselbl.setBounds(625,200,200,30);
        courselbl.setFont(new Font("Comic Sans MS",Font.BOLD,22));
        add(courselbl);

        JLabel course=new JLabel();
        course.setBounds(730,200,200,30);
        course.setFont(new Font("Comic Sans MS",Font.PLAIN,22));
        add(course);

        JLabel semlbl=new JLabel("Semester");
        semlbl.setBounds(1125,200,200,30);
        semlbl.setFont(new Font("Comic Sans MS",Font.BOLD,22));
        add(semlbl);

        JLabel sem=new JLabel();
        sem.setBounds(1250,200,200,30);
        sem.setFont(new Font("Comic Sans MS",Font.PLAIN,22));
        add(sem);

        JLabel sub1=new JLabel();
        sub1.setBounds(500,300,200,30);
        sub1.setFont(new Font("Comic Sans MS",Font.BOLD,22));
        add(sub1);

        JLabel sub2=new JLabel();
        sub2.setBounds(500,340,200,30);
        sub2.setFont(new Font("Comic Sans MS",Font.BOLD,22));
        add(sub2);

        JLabel sub3=new JLabel();
        sub3.setBounds(500,380,200,30);
        sub3.setFont(new Font("Comic Sans MS",Font.BOLD,22));
        add(sub3);

        JLabel sub4=new JLabel();
        sub4.setBounds(500,420,200,30);
        sub4.setFont(new Font("Comic Sans MS",Font.BOLD,22));
        add(sub4);

        JLabel sub5=new JLabel();
        sub5.setBounds(500,460,200,30);
        sub5.setFont(new Font("Comic Sans MS",Font.BOLD,22));
        add(sub5);

        JLabel m1=new JLabel();
        m1.setBounds(850,300,200,30);
        m1.setFont(new Font("Comic Sans MS",Font.BOLD,22));
        add(m1);

        JLabel m2=new JLabel();
        m2.setBounds(850,340,200,30);
        m2.setFont(new Font("Comic Sans MS",Font.BOLD,22));
        add(m2);

        JLabel m3=new JLabel();
        m3.setBounds(850,380,200,30);
        m3.setFont(new Font("Comic Sans MS",Font.BOLD,22));
        add(m3);

        JLabel m4=new JLabel();
        m4.setBounds(850,420,200,30);
        m4.setFont(new Font("Comic Sans MS",Font.BOLD,22));
        add(m4);

        JLabel m5=new JLabel();
        m5.setBounds(850,460,200,30);
        m5.setFont(new Font("Comic Sans MS",Font.BOLD,22));
        add(m5);

        try{
            Conn c =new Conn();
            ResultSet rs1=c.s.executeQuery("select * from subject where Roll_No='"+rollno+"'");

            while(rs1.next()){

                sem.setText(rs1.getString("Semester"));
                sub1.setText(rs1.getString("Subject_01"));
                sub2.setText(rs1.getString("Subject_02"));
                sub3.setText(rs1.getString("Subject_03"));
                sub4.setText(rs1.getString("Subject_04"));
                sub5.setText(rs1.getString("Subject_05"));
            }

            ResultSet rs2=c.s.executeQuery("select * from marks where Roll_No='"+rollno+"'");

            while(rs2.next()){
                m1.setText(rs2.getString("Marks_01"));
                m2.setText(rs2.getString("Marks_02"));
                m3.setText(rs2.getString("Marks_03"));
                m4.setText(rs2.getString("Marks_04"));
                m5.setText(rs2.getString("Marks_05"));
            }

            ResultSet rs3=c.s.executeQuery("select * from student where Roll_No='"+rollno+"'");
            while(rs3.next()){
                roll.setText(rs3.getString("Roll_No"));
                course.setText(rs3.getString("Course"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        check=new JButton("Check Another");
        check.setBounds(350,550,300,50);
        check.setFont(new Font("Comic Sans MS",Font.BOLD,28));
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);

        cancel=new JButton("Cancel");
        cancel.setBounds(750,550,300,50);
        cancel.setFont(new Font("Comic Sans MS",Font.BOLD,28));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        exit=new JButton("EXIT");
        exit.setBounds(1400,0,75,25);
        exit.setFont(new Font("Comic Sans MS",Font.BOLD,12));
        exit.setForeground(Color.RED);
        exit.addActionListener(this);
        add(exit);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==check){
            dispose();
            new ExamDetails();
        }
        if(ae.getSource()==cancel){
            dispose();
            new Project();
        }
        if(ae.getSource()==exit)
            dispose();

    }

    public static void main(String[] args) {
        new Marks("");
    }
}


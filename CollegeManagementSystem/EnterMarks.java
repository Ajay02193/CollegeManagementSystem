package CollegeManagementSystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class EnterMarks extends JFrame implements ActionListener {

    Choice crollno;
    JComboBox coursejcb,semjcb;
    JButton submit,cancel,exit;
    JTextField sub1,sub2,sub3,sub4,sub5,marks1,marks2,marks3,marks4,marks5;


    EnterMarks(){
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

        JLabel heading = new JLabel("Enter Marks Information");
        heading.setBounds(550,125,500,50);
        heading.setFont(new Font("Comic Sans MS",Font.BOLD,30));
        add(heading);

        JLabel rolllbl=new JLabel("Search By Roll No");
        rolllbl.setBounds(635,180,200,30);
        rolllbl.setFont(new Font("Comic Sans MS",Font.BOLD,22));
        add(rolllbl);

        crollno=new Choice();
        crollno.setBounds(635,225,200,50);
        crollno.setFont(new Font("Comic Sans MS",Font.PLAIN,18));
        add(crollno);

        try{

            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from student");
            while(rs.next()){
                crollno.add(rs.getString("Roll_No"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel courselbl = new JLabel("Course");
        courselbl.setBounds(500,255,200,50);
        courselbl.setFont(new Font("Comic Sans MS",Font.BOLD,22));
        add(courselbl);

        String course[]={"B.Tech","BCA","BBA","M.Tech","MCA","MBA"};
        coursejcb =new JComboBox(course);
        coursejcb.setBounds(440,310,200,30);
        coursejcb.setFont(new Font("Comic Sans Ms",Font.PLAIN,18));
        coursejcb.setBackground(Color.WHITE);
        add(coursejcb);

        JLabel semlbl=new JLabel("Semester");
        semlbl.setBounds(890,255,200,50);
        semlbl.setFont(new Font("Comic Sans MS",Font.BOLD,22));
        add(semlbl);

        String sem[]={"1st","2nd","3rd","4th","5th","6th","7th","8th"};
        semjcb =new JComboBox(sem);
        semjcb.setBounds(840,310,200,30);
        semjcb.setFont(new Font("Comic Sans Ms",Font.PLAIN,18));
        semjcb.setBackground(Color.WHITE);
        add(semjcb);

        JLabel sublbl=new JLabel("Enter Subject");
        sublbl.setBounds(475,350,200,50);
        sublbl.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        add(sublbl);

        JLabel markslbl=new JLabel("Enter Marks");
        markslbl.setBounds(875,350,200,50);
        markslbl.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        add(markslbl);

        sub1=new JTextField();
        sub1.setBounds(350,400,400,35);
        sub1.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
        add(sub1);

        sub2=new JTextField();
        sub2.setBounds(350,435,400,35);
        sub2.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
        add(sub2);

        sub3=new JTextField();
        sub3.setBounds(350,470,400,35);
        sub3.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
        add(sub3);

        sub4=new JTextField();
        sub4.setBounds(350,505,400,35);
        sub4.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
        add(sub4);

        sub5=new JTextField();
        sub5.setBounds(350,540,400,35);
        sub5.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
        add(sub5);

        marks1=new JTextField();
        marks1.setBounds(750,400,400,35);
        marks1.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
        add(marks1);

        marks2=new JTextField();
        marks2.setBounds(750,435,400,35);
        marks2.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
        add(marks2);

        marks3=new JTextField();
        marks3.setBounds(750,470,400,35);
        marks3.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
        add(marks3);

        marks4=new JTextField();
        marks4.setBounds(750,505,400,35);
        marks4.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
        add(marks4);

        marks5=new JTextField();
        marks5.setBounds(750,540,400,35);
        marks5.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
        add(marks5);

        submit=new JButton("Submit");
        submit.setBounds(525,600,200,50);
        submit.setFont(new Font("Comic Sans MS",Font.BOLD,24));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBounds(775,600,200,50);
        cancel.setFont(new Font("Comic Sans MS",Font.BOLD,24));
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

        if (ae.getSource() == submit) {
            Conn c = new Conn();

            String roll = crollno.getSelectedItem();
            String course = (String) coursejcb.getSelectedItem();
            String sem = (String) semjcb.getSelectedItem();
            String s1 = sub1.getText();
            String s2 = sub2.getText();
            String s3 = sub3.getText();
            String s4 = sub4.getText();
            String s5 = sub5.getText();

            String query1 = "insert into subject values('" + roll + "','" + course + "','" + sem + "','" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "')";

            String m1 = marks1.getText();
            String m2 = marks2.getText();
            String m3 = marks3.getText();
            String m4 = marks4.getText();
            String m5 = marks5.getText();

            String query2 = "insert into marks values('" + roll + "','" + course + "','" + sem + "','" + m1 + "','" + m2 + "','" + m3 + "','" + m4 + "','" + m5 + "')";

            try {
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Marks Submitted Successfully");

                dispose();
                new Project();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if(ae.getSource()==cancel){
            setVisible(false);
            new Project();
        }
        if(ae.getSource()==exit)
            setVisible(false);

    }

    public static void main(String[] args) {
        new EnterMarks();
    }

}


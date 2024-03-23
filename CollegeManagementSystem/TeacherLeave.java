package CollegeManagementSystem;

import com.toedter.calendar.JDateChooser;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TeacherLeave extends JFrame implements ActionListener{

    Choice cemp, ctime;
    JDateChooser dcd;
    JButton submit, cancel, exit;

    TeacherLeave(){getContentPane().setBackground(Color.WHITE);
        setSize(1500,800);
        setLocation(25,20);
        setLayout(null);

        ImageIcon i5=new ImageIcon(ClassLoader.getSystemResource("CollegeManagementSystem/icons/logo.png"));
        Image i6=i5.getImage().getScaledInstance(599, 100, Image.SCALE_SMOOTH);
        ImageIcon i7=new ImageIcon(i6);
        JLabel logo1 = new JLabel(i7);
        logo1.setBounds(345,-50,700,200);
        add(logo1);

        JLabel heading = new JLabel("Student Leave Apply");
        heading.setBounds(585,125,500,50);
        heading.setFont(new Font("Comic Sans MS",Font.BOLD,30));
        add(heading);

        JLabel emplbl=new JLabel("Search By Employee ID");
        emplbl.setBounds(605,200,275,30);
        emplbl.setFont(new Font("Comic Sans MS",Font.BOLD,22));
        add(emplbl);

        cemp=new Choice();
        cemp.setBounds(635,245,200,50);
        cemp.setFont(new Font("Comic Sans MS",Font.PLAIN,18));
        add(cemp);

        try{

            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from teacher");
            while(rs.next()){
                cemp.add(rs.getString("Emp_ID"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel datelbl=new JLabel("Date");
        datelbl.setBounds(695,300,200,30);
        datelbl.setFont(new Font("Comic Sans MS",Font.BOLD,22));
        add(datelbl);

        dcd=new JDateChooser();
        dcd.setBounds(635,350,200,50);
        dcd.setFont(new Font("Comic Sans MS",Font.PLAIN,18));
        add(dcd);

        JLabel timelbl=new JLabel("Time Duration");
        timelbl.setBounds(655,420,200,30);
        timelbl.setFont(new Font("Comic Sans MS",Font.BOLD,22));
        add(timelbl);

        ctime=new Choice();
        ctime.setBounds(635,465,200,50);
        ctime.setFont(new Font("Comic Sans MS",Font.PLAIN,18));
        ctime.add("Half Day");
        ctime.add("Full Day");
        add(ctime);

        submit=new JButton("Submit");
        submit.setBounds(525,535,200,50);
        submit.setFont(new Font("Comic Sans MS",Font.BOLD,24));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBounds(745,535,200,50);
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
        if(ae.getSource()==submit){

            String emp=(String)cemp.getSelectedItem();
            String date=((JTextField)dcd.getDateEditor().getUiComponent()).getText();
            String time=(String)ctime.getSelectedItem();

            try{
                String query="insert into teacherleave values('"+emp+"','"+date+"','"+time+"')";
                Conn con=new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Teacher Leave Applied Successfully");

                setVisible(false);
                new Project();

            }catch(Exception e){
                e.printStackTrace();
            }}
        if(ae.getSource()==cancel){
            setVisible(false);
            new Project();
        }
        if(ae.getSource()==exit)
            setVisible(false);
    }

    public static void main(String[] args) {
        new TeacherLeave();
    }

}

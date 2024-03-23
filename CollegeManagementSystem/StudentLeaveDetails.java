package CollegeManagementSystem;

import java.awt.Choice;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;


public class StudentLeaveDetails extends JFrame implements ActionListener{

    Choice crollno;
    JTable table;
    JButton search, add, print, cancel, exit;

    StudentLeaveDetails(){

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

        JLabel heading = new JLabel("Student Leave Information");
        heading.setBounds(550,125,500,50);
        heading.setFont(new Font("Comic Sans MS",Font.BOLD,30));
        add(heading);

        JLabel srclbl=new JLabel("Search By Roll No");
        srclbl.setBounds(125,185,150,50);
        srclbl.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        add(srclbl);

        crollno=new Choice();
        crollno.setBounds(300,195,300,50);
        crollno.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
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

        table =new JTable();
        table.setFont(new Font("Comic Sans MS",Font.PLAIN,12));

        try{

            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from studentleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
            e.printStackTrace();
        }

        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(20,235,1448,525);
        add(jsp);

        search=new JButton("Search");
        search.setBounds(625,196,125,25);
        search.setFont(new Font("Comic Sans MS",Font.BOLD,14));
        search.addActionListener(this);
        add(search);

        add=new JButton("Add");
        add.setBounds(760,196,125,25);
        add.setFont(new Font("Comic Sans MS",Font.BOLD,14));
        add.addActionListener(this);
        add(add);

        print=new JButton("Print");
        print.setBounds(895,196,125,25);
        print.setFont(new Font("Comic Sans MS",Font.BOLD,14));
        print.addActionListener(this);
        add(print);

        cancel=new JButton("Cancel");
        cancel.setBounds(1030,196,125,25);
        cancel.setFont(new Font("Comic Sans MS",Font.BOLD,14));
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

    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource()==search){
            String query="select * from studentleave where Roll_No ='"+crollno.getSelectedItem()+"'";
            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        if(ae.getSource()==add){
            setVisible(false);
            new StudentLeave();
        }

        if(ae.getSource()==print){
            try{
                table.print();
            }catch(Exception e){
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
        new StudentLeaveDetails();
    }

}

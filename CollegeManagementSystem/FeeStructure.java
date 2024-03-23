package CollegeManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;

public class FeeStructure extends JFrame implements ActionListener {
    JButton print, cancel, pay, exit;
    JTable table;

    FeeStructure(){
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

        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(635,125,500,50);
        heading.setFont(new Font("Comic Sans MS",Font.BOLD,30));
        add(heading);

        table =new JTable();
        table.setFont(new Font("Comic Sans MS",Font.PLAIN,18));
        table.setRowHeight(35);

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(50,200,1390,245);
        add(jsp);

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }

        print=new JButton("Print");
        print.setBounds(300,500,200,50);
        print.setFont(new Font("Comic Sans MS",Font.BOLD,24));
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.addActionListener(this);
        add(print);

        pay=new JButton("Pay Now");
        pay.setBounds(650,500,200,50);
        pay.setFont(new Font("Comic Sans MS",Font.BOLD,24));
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        add(pay);

        cancel=new JButton("Cancel");
        cancel.setBounds(1000,500,200,50);
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

        if(ae.getSource()==print)
        { try{
            table.print();
        }catch(Exception e){
            e.printStackTrace();
        }
        }
        if(ae.getSource()==pay){
            dispose();
            new FeeForm();
        }
        if(ae.getSource()==cancel){
            dispose();
            new Project();
        }
        if(ae.getSource()==exit)
            dispose();
    }

    public static void main(String[] args) {
        new FeeStructure();
    }

}


package CollegeManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class ExamDetails extends JFrame implements ActionListener{

    JTable table;
    JTextField rolltxt;
    JButton search,cancel,print,exit;

    ExamDetails(){

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

        JLabel heading = new JLabel("Marks Information");
        heading.setBounds(590,125,500,50);
        heading.setFont(new Font("Comic Sans MS",Font.BOLD,30));
        add(heading);

        JLabel rolllbl=new JLabel("Roll No");
        rolllbl.setBounds(575,200,200,30);
        rolllbl.setFont(new Font("Comic Sans MS",Font.BOLD,22));
        add(rolllbl);

        rolltxt=new JTextField();
        rolltxt.setBounds(700,200,200,30);
        rolltxt.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
        add(rolltxt);

        table=new JTable();
        table.setFont(new Font("Comic Sans MS",Font.PLAIN,12));

        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(50,325,1400,400);
        add(jsp);

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select* from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
            e.printStackTrace();
        }

        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                int row = table.getSelectedRow();
                rolltxt.setText(table.getModel().getValueAt(row,2).toString());
            }
        });

        search=new JButton("Search");
        search.setBounds(525,250,150,35);
        search.setFont(new Font("Comic Sans MS",Font.BOLD,22));
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        add(search);

        cancel=new JButton("Cancel");
        cancel.setBounds(685,250,150,35);
        cancel.setFont(new Font("Comic Sans MS",Font.BOLD,22));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        print=new JButton("Print");
        print.setBounds(845,250,150,35);
        print.setFont(new Font("Comic Sans MS",Font.BOLD,22));
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(print);


        exit=new JButton("EXIT");
        exit.setBounds(1400,0,75,25);
        exit.setFont(new Font("Comic Sans MS",Font.BOLD,12));
        exit.setForeground(Color.RED);
        exit.addActionListener(this);
        add(exit);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            dispose();
            new Marks(rolltxt.getText());
        }
        if(ae.getSource()==cancel){
            dispose();
            new Project();
        }
        if(ae.getSource()==print){
            try{

            }catch(Exception e){
                e.printStackTrace();
            }
        }
        if(ae.getSource()==exit)
            dispose();

    }

    public static void main(String[] args) {
        new ExamDetails();
    }

}


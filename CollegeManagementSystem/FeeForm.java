package CollegeManagementSystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FeeForm extends JFrame implements ActionListener{

    Choice crollno;
    JComboBox coursejcb,branchjcb,semjcb;
    JButton check,pay,cancel,exit;
    JLabel totaltxt,studenttxt;

    FeeForm(){
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

        JLabel heading = new JLabel("Fee Form");
        heading.setBounds(675,125,500,50);
        heading.setFont(new Font("Comic Sans MS",Font.BOLD,30));
        add(heading);

        JLabel srclbl=new JLabel("Select Roll No");
        srclbl.setBounds(550,185,150,50);
        srclbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(srclbl);

        crollno=new Choice();
        crollno.setBounds(725,195,250,50);
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



        JLabel studentlbl = new JLabel("Student Name");
        studentlbl.setBounds(550,235,500,50);
        studentlbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(studentlbl);

        studenttxt =new JLabel("Student Name");
        studenttxt.setBounds(725,235,250,50);
        studenttxt.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(studenttxt);

        JLabel guardianlbl = new JLabel("Guardian Name");
        guardianlbl.setBounds(550,275,500,50);
        guardianlbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(guardianlbl);

        JLabel guardiantxt =new JLabel("Guardian Name");
        guardiantxt.setBounds(725,275,250,50);
        guardiantxt.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(guardiantxt);

        JLabel courselbl = new JLabel("Course");
        courselbl.setBounds(550,330,500,50);
        courselbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(courselbl);

        String course[]={"BTech","BCA","BBA","MTech","MCA","MBA"};
        coursejcb =new JComboBox(course);
        coursejcb.setBounds(725,330,250,50);
        coursejcb.setFont(new Font("Comic Sans Ms",Font.PLAIN,18));
        coursejcb.setBackground(Color.WHITE);
        add(coursejcb);

        JLabel branchlbl=new JLabel("Branch");
        branchlbl.setBounds(550,400,500,50);
        branchlbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(branchlbl);

        String branch[]={"General","CSE","CST","AI/ML","Data Science","Human Resource","International Business","Marketing"};
        branchjcb = new JComboBox(branch);
        branchjcb.setBounds(725,400,250,50);
        branchjcb.setFont(new Font("Comic Sans MS",Font.PLAIN,18));
        branchjcb.setBackground(Color.WHITE);
        add(branchjcb);

        try{
            Conn c=new Conn();
            String query="select * from student where Roll_No='"+crollno.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);

            while(rs.next()){
                studenttxt.setText(rs.getString("Name"));
                guardiantxt.setText(rs.getString("Guardian_Name"));
                coursejcb.setSelectedItem(rs.getString("Course"));
                branchjcb.setSelectedItem(rs.getString("Branch"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        crollno.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){

                try{
                    Conn c=new Conn();
                    String query="select * from student where Roll_No='"+crollno.getSelectedItem()+"'";
                    ResultSet rs=c.s.executeQuery(query);

                    while(rs.next()){
                        studenttxt.setText(rs.getString("Name"));
                        guardiantxt.setText(rs.getString("Guardian_Name"));
                        coursejcb.setSelectedItem(rs.getString("Course"));
                        branchjcb.setSelectedItem(rs.getString("Branch"));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        JLabel semlbl=new JLabel("Semester");
        semlbl.setBounds(550,470,200,50);
        semlbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(semlbl);

        String sem[]={"Sem_01","Sem_02","Sem_03","Sem_04","Sem_05","Sem_06","Sem_07","Sem_08"};
        semjcb =new JComboBox(sem);
        semjcb.setBounds(725,475,250,50);
        semjcb.setFont(new Font("Comic Sans Ms",Font.PLAIN,18));
        semjcb.setBackground(Color.WHITE);
        add(semjcb);

        JLabel totallbl = new JLabel("Total Payable");
        totallbl.setBounds(550,535,500,50);
        totallbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(totallbl);

        totaltxt =new JLabel();
        totaltxt.setBounds(725,535,250,50);
        totaltxt.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(totaltxt);

        check =new JButton("Check Fee");
        check.setBounds(500,600,150,50);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        check.addActionListener(this);
        add(check);

        pay =new JButton("Pay");
        pay.setBounds(685,600,150,50);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        pay.addActionListener(this);
        add(pay);

        cancel=new JButton("Cancel");
        cancel.setBounds(870,600,150,50);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Comic Sans MS",Font.BOLD,18));
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
            String course=(String)coursejcb.getSelectedItem();
            String sem=(String)semjcb.getSelectedItem();
            try{
                Conn c =new Conn();
                ResultSet rs=c.s.executeQuery("select * from fee where Course='"+course+"'");

                while(rs.next()){
                    totaltxt.setText(rs.getString(sem));
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }

        if(ae.getSource()==pay){

            String roll = crollno.getSelectedItem();
            String course = (String) coursejcb.getSelectedItem();
            String branch = (String) branchjcb.getSelectedItem();
            String sem = (String) semjcb.getSelectedItem();
            String total = totaltxt.getText();
            String name=studenttxt.getText();

            String query="insert into feepay values('"+roll+"','"+name+"','"+course+"','"+branch+"','"+sem+"','"+total+"')";
            String queryc="select * from feepay where Roll_No='"+roll+"'";

            try{

                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(queryc);
                boolean alreadypaid=false;
                while(rs.next()){
                    if(sem.equals(rs.getString("Semester")) && roll.equals(rs.getString("Roll_No"))){
                        alreadypaid=true;
                        break;
                    }
                }
                if(alreadypaid){
                    JOptionPane.showMessageDialog(null,"Already Paid");}
                else{
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null,"Fee Payment Successful");

                    dispose();
                    new FeeForm();}

            }catch(Exception e){
                e.printStackTrace();
            }

        }

        if(ae.getSource()==cancel){
            dispose();
            new Project();
        }

        if(ae.getSource()==exit)
            dispose();

    }

    public static void main(String[] args) {
        new FeeForm();
    }

}


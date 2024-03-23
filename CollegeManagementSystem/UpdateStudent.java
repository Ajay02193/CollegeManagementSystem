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
import javax.swing.JTextField;


public class UpdateStudent extends JFrame implements ActionListener{

    JComboBox coursejcb, branchjcb;
    JTextField addresstxt, phonetxt, emailtxt;
    JButton update, delete, cancel, exit;
    Choice crollno;

    UpdateStudent(){
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

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(560,125,500,50);
        heading.setFont(new Font("Comic Sans MS",Font.BOLD,30));
        add(heading);

        JLabel srclbl=new JLabel("Search By Roll No");
        srclbl.setBounds(125,150,150,50);
        srclbl.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        add(srclbl);

        crollno=new Choice();
        crollno.setBounds(275,163,150,50);
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



        JLabel studentlbl = new JLabel("Student Name");
        studentlbl.setBounds(225,200,500,50);
        studentlbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(studentlbl);

        JLabel studenttxt =new JLabel();
        studenttxt.setBounds(375,200,250,50);
        studenttxt.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(studenttxt);

        JLabel guardianlbl = new JLabel("Guardian Name");
        guardianlbl.setBounds(750,200,500,50);
        guardianlbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(guardianlbl);

        JLabel guardiantxt =new JLabel();
        guardiantxt.setBounds(915,200,250,50);
        guardiantxt.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(guardiantxt);

        JLabel rolllbl=new JLabel("Roll Number");
        rolllbl.setBounds(225,275,500,50);
        rolllbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(rolllbl);

        JLabel rolltxt=new JLabel();
        rolltxt.setBounds(375,275,250,50);
        rolltxt.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(rolltxt);

        JLabel doblbl=new JLabel("Date Of Birth");
        doblbl.setBounds(750,275,500,50);
        doblbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(doblbl);

        JLabel dobtxt=new JLabel();
        dobtxt.setBounds(915,275,250,50);
        dobtxt.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(dobtxt);

        JLabel addresslbl=new JLabel("Address");
        addresslbl.setBounds(225,350,500,50);
        addresslbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(addresslbl);

        addresstxt=new JTextField();
        addresstxt.setBounds(375,350,250,50);
        addresstxt.setFont(new Font("Comic Sans MS",Font.PLAIN,18));
        add(addresstxt);

        JLabel aadharlbl=new JLabel("Aadhar Number");
        aadharlbl.setBounds(750,350,500,50);
        aadharlbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(aadharlbl);

        JLabel aadhartxt=new JLabel();
        aadhartxt.setBounds(915,350,250,50);
        aadhartxt.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(aadhartxt);

        JLabel phonelbl=new JLabel("Contact Number");
        phonelbl.setBounds(225,425,500,50);
        phonelbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(phonelbl);

        phonetxt=new JTextField();
        phonetxt.setBounds(375,425,250,50);
        phonetxt.setFont(new Font("Comic Sans MS",Font.PLAIN,18));
        add(phonetxt);

        JLabel emaillbl=new JLabel("Email ID");
        emaillbl.setBounds(750,425,500,50);
        emaillbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(emaillbl);

        emailtxt = new JTextField();
        emailtxt.setBounds(915,425,250,50);
        emailtxt.setFont(new Font("Comic Sans MS",Font.PLAIN,18));
        add(emailtxt);

        JLabel xlbl= new JLabel("10th Percentage");
        xlbl.setBounds(225,500,500,50);
        xlbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(xlbl);

        JLabel xtxt=new JLabel();
        xtxt.setBounds(380,500,250,50);
        xtxt.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(xtxt);

        JLabel xiilbl = new JLabel("12th Percentage");
        xiilbl.setBounds(750,500,500,50);
        xiilbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(xiilbl);

        JLabel xiitxt=new JLabel();
        xiitxt.setBounds(915,500,250,50);
        xiitxt.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(xiitxt);

        JLabel courselbl = new JLabel("Course");
        courselbl.setBounds(225,575,500,50);
        courselbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(courselbl);

        String course[]={"B.Tech","BCA","BBA","M.Tech","MCA","MBA"};
        coursejcb =new JComboBox(course);
        coursejcb.setBounds(375,575,250,50);
        coursejcb.setFont(new Font("Comic Sans Ms",Font.PLAIN,18));
        coursejcb.setBackground(Color.WHITE);
        add(coursejcb);

        JLabel branchlbl=new JLabel("Branch");
        branchlbl.setBounds(750,575,500,50);
        branchlbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(branchlbl);

        String branch[]={"General","CSE","CST","AI/ML","Data Science","Human Resource","International Business","Marketing"};
        branchjcb = new JComboBox(branch);
        branchjcb.setBounds(915,575,250,50);
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
                rolltxt.setText(rs.getString("Roll_No"));
                dobtxt.setText(rs.getString("Date_Of_Birth"));
                addresstxt.setText(rs.getString("Address"));
                aadhartxt.setText(rs.getString("Aadhar_No"));
                phonetxt.setText(rs.getString("Phone_No"));
                emailtxt.setText(rs.getString("Email_Id"));
                xtxt.setText(rs.getString("X_th"));
                xiitxt.setText(rs.getString("XII_th"));
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
                        rolltxt.setText(rs.getString("Roll_No"));
                        dobtxt.setText(rs.getString("Date_Of_Birth"));
                        addresstxt.setText(rs.getString("Address"));
                        aadhartxt.setText(rs.getString("Aadhar_No"));
                        phonetxt.setText(rs.getString("Phone_No"));
                        emailtxt.setText(rs.getString("Email_Id"));
                        xtxt.setText(rs.getString("X_th"));
                        xiitxt.setText(rs.getString("XII_th"));
                        coursejcb.setSelectedItem(rs.getString("Course"));
                        branchjcb.setSelectedItem(rs.getString("Branch"));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        update =new JButton("Update");
        update.setBounds(375,660,150,50);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        update.addActionListener(this);
        add(update);

        delete =new JButton("Delete");
        delete.setBounds(685,660,150,50);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        delete.addActionListener(this);
        add(delete);

        cancel=new JButton("Cancel");
        cancel.setBounds(985,660,150,50);
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

        if(ae.getSource()==update){

            try{

                String add=addresstxt.getText();
                String phone=phonetxt.getText();
                String email=emailtxt.getText();
                String course=(String)coursejcb.getSelectedItem();
                String branch=(String)branchjcb.getSelectedItem();
                String roll=crollno.getSelectedItem();

                String query="update student set Address='"+add+"',Phone_No='"+phone+"',Email_Id='"+email+"',Course='"+course+"',Branch='"+branch+"' where Roll_No='"+roll+"'";

                Conn c=new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Student Details Updated Successfully");

                dispose();
                new Project();

            }catch(Exception e){
                e.printStackTrace();
            }
        }
        String roll=crollno.getSelectedItem();
        if(ae.getSource()==delete){
            try{
                Conn c=new Conn();

                String query="delete from student where Roll_No='"+crollno.getSelectedItem()+"'";

                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,roll+" Data Deleted Successfully");

                dispose();
                new UpdateStudent();

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
        new UpdateStudent();
    }
}

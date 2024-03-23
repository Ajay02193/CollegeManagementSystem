package CollegeManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.sql.*;


public class AddStudent extends JFrame implements ActionListener{

    JTextField studenttxt, guardiantxt, addresstxt, aadhartxt, phonetxt, emailtxt, xtxt, xiitxt;
    JLabel rolltxt;
    JDateChooser dcdob;
    JComboBox coursejcb, branchjcb;
    JButton submit, cancel, exit;
    String Course;
    long roll;

    AddStudent(){

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

        JLabel heading = new JLabel("New Student Information");
        heading.setBounds(530,125,500,50);
        heading.setFont(new Font("Comic Sans MS",Font.BOLD,30));
        add(heading);

        JLabel studentlbl = new JLabel("Student Name");
        studentlbl.setBounds(225,200,500,50);
        studentlbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(studentlbl);

        studenttxt =new JTextField("Enter Name");
        studenttxt.setBounds(375,200,250,50);
        studenttxt.setFont(new Font("Comic Sans MS",Font.PLAIN,18));
        add(studenttxt);

        JLabel guardianlbl = new JLabel("Guardian Name");
        guardianlbl.setBounds(750,200,500,50);
        guardianlbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(guardianlbl);

        guardiantxt =new JTextField("Enter Guardian Name");
        guardiantxt.setBounds(915,200,250,50);
        guardiantxt.setFont(new Font("Comic Sans MS",Font.PLAIN,18));
        add(guardiantxt);

        JLabel rolllbl=new JLabel("Roll Number");
        rolllbl.setBounds(225,275,500,50);
        rolllbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(rolllbl);

        String course[]={"B.Tech","BCA","BBA","M.Tech","MCA","MBA"};
        coursejcb =new JComboBox(course);
        coursejcb.setBounds(375,575,250,50);
        coursejcb.setFont(new Font("Comic Sans Ms",Font.PLAIN,18));
        coursejcb.setBackground(Color.WHITE);
        add(coursejcb);

        Course=(String) coursejcb.getSelectedItem();

        roll=generateRoll();

        coursejcb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                Course=(String) coursejcb.getSelectedItem();
                rolltxt.setText("23"+Course+roll);

            }
        });

        rolltxt = new JLabel("23"+ Course +roll);
        rolltxt.setBounds(375,275,250,50);
        rolltxt.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(rolltxt);

        JLabel doblbl=new JLabel("Date Of Birth");
        doblbl.setBounds(750,275,500,50);
        doblbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(doblbl);

        dcdob=new JDateChooser();
        dcdob.setBounds(915,275,250,50);
        dcdob.setFont(new Font("Comic Sans MS",Font.PLAIN,18));
        add(dcdob);

        JLabel addresslbl=new JLabel("Address");
        addresslbl.setBounds(225,350,500,50);
        addresslbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(addresslbl);

        addresstxt=new JTextField("Enter Address");
        addresstxt.setBounds(375,350,250,50);
        addresstxt.setFont(new Font("Comic Sans MS",Font.PLAIN,18));
        add(addresstxt);

        JLabel aadharlbl=new JLabel("Aadhar Number");
        aadharlbl.setBounds(750,350,500,50);
        aadharlbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(aadharlbl);

        aadhartxt=new JTextField("XXXX-XXXX-XXXX");
        aadhartxt.setBounds(915,350,250,50);
        aadhartxt.setFont(new Font("Comic Sans MS",Font.PLAIN,18));
        add(aadhartxt);

        JLabel phonelbl=new JLabel("Contact Number");
        phonelbl.setBounds(225,425,500,50);
        phonelbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(phonelbl);

        phonetxt=new JTextField("XXXXX-XXXXX");
        phonetxt.setBounds(375,425,250,50);
        phonetxt.setFont(new Font("Comic Sans MS",Font.PLAIN,18));
        add(phonetxt);

        JLabel emaillbl=new JLabel("Email ID");
        emaillbl.setBounds(750,425,500,50);
        emaillbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(emaillbl);

        emailtxt = new JTextField("xxxxx@email.com");
        emailtxt.setBounds(915,425,250,50);
        emailtxt.setFont(new Font("Comic Sans MS",Font.PLAIN,18));
        add(emailtxt);

        JLabel xlbl= new JLabel("10th Percentage");
        xlbl.setBounds(225,500,500,50);
        xlbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(xlbl);

        xtxt=new JTextField("10th Percentage");
        xtxt.setBounds(375,500,250,50);
        xtxt.setFont(new Font("Comic Sans MS",Font.PLAIN,18));
        add(xtxt);

        JLabel xiilbl = new JLabel("12th Percentage");
        xiilbl.setBounds(750,500,500,50);
        xiilbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(xiilbl);

        xiitxt=new JTextField("12th Percentage");
        xiitxt.setBounds(915,500,250,50);
        xiitxt.setFont(new Font("Comic Sans MS",Font.PLAIN,18));
        add(xiitxt);

        JLabel courselbl = new JLabel("Course");
        courselbl.setBounds(225,575,500,50);
        courselbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(courselbl);

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

        submit =new JButton("Submit");
        submit.setBounds(425,660,150,50);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBounds(825,660,150,50);
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
        if(ae.getSource()==submit){

            String name=studenttxt.getText();
            String gname=guardiantxt.getText();
            String rol=rolltxt.getText();

            Date date=dcdob.getDate();
            SimpleDateFormat sqlformat= new SimpleDateFormat("yyyy-MM-dd");
            String dob=sqlformat.format(date);

            String address=addresstxt.getText();
            String aadhar=aadhartxt.getText();
            String phone=phonetxt.getText();
            String email=emailtxt.getText();
            String x=xtxt.getText();
            String xii=xiitxt.getText();
            String course=(String)coursejcb.getSelectedItem();
            String branch=(String)branchjcb.getSelectedItem();


            boolean proceed=false;
            boolean isEmail=isValidEmail(email);
            if(!isEmail){
                proceed=false;
                JOptionPane.showMessageDialog(null,"Invalid Email");
            }

            else if(phone.length()!=10){
                proceed=false;
                JOptionPane.showMessageDialog(null,"Invalid Contact No.");
            }

            else if(aadhar.length()!=12){
                proceed=false;
                JOptionPane.showMessageDialog(null,"Invalid Aadhar");
            }

            else if(Integer.parseInt(x)>100||Integer.parseInt(x)<50){
                proceed=false;
                JOptionPane.showMessageDialog(null, "Invalid Xth Percentage");
            }

            else if(Integer.parseInt(xii)>100||Integer.parseInt(xii)<35){
                proceed=false;
                JOptionPane.showMessageDialog(null, "Invalid XIIth Percentage");
            }
            else
                proceed=true;


            if(proceed==true){
                try{

                    String query="insert into student values('"+roll+"','"+name+"','"+gname+"','"+rol+"','"+dob+"','"+address+"','"+aadhar+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+course+"','"+branch+"')";

                    Conn con=new Conn();
                    con.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null,"Student Details Submitted Successfully");

                    dispose();
                    new AddStudent();

                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error: "+ e.getMessage());
                }
            }


        }
        else if(ae.getSource()==cancel){
            dispose();
            new Project();
        }
        else if(ae.getSource()==exit)
            dispose();

    }

    private long generateRoll() {
        long nextroll = 1; // Initial next employee ID

        try {
            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery("SELECT S_No FROM student ORDER BY S_No ASC");

            // Track the last seen employee ID
            long lastRoll = 0;

            // Iterate over each employee ID
            while (rs.next()) {
                long roll = rs.getLong("S_No");

                // If there's a gap between lastEmpId and the current empId, fill the gap
                if (roll - lastRoll > 1) {
                    nextroll = lastRoll + 1;
                    break;
                }

                lastRoll = roll; // Update the last seen employee ID
            }

            // If all employee IDs are occupied, increment the last one by 1
            if (nextroll == 1) {
                nextroll = lastRoll + 1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return nextroll;
    }


        public static boolean isValidEmail(String email) {
            // Check if email is null or empty
            if (email == null || email.isEmpty()) {
                return false;
            }

            // Check if email contains '@' symbol
            int atIndex = email.indexOf('@');
            if (atIndex == -1) {
                return false;
            }

            // Check if there is at least one character before '@'
            if (atIndex == 0) {
                return false;
            }

            // Check if email contains '.' symbol after '@'
            int dotIndex = email.indexOf('.', atIndex);
            if (dotIndex == -1) {
                return false;
            }

            // Check if there is at least one character between '@' and '.'
            if (dotIndex - atIndex <= 1) {
                return false;
            }

            // Check if there is at least one character after '.'
            if (dotIndex == email.length() - 1) {
                return false;
            }

            return true;
        }

    public static void main(String[] args) {
        new AddStudent();
    }
}


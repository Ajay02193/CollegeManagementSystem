package CollegeManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
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


public class AddTeacher extends JFrame implements ActionListener{

    JTextField teachertxt, guardiantxt, addresstxt, aadhartxt, phonetxt, emailtxt, xtxt, xiitxt;
    JLabel emptxt;
    JDateChooser dcdob;
    JComboBox qualijcb, depjcb;
    JButton submit, cancel, exit;
    long nextEmpNo;

    AddTeacher(){

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

        JLabel heading = new JLabel("New Teacher Information");
        heading.setBounds(530,125,500,50);
        heading.setFont(new Font("Comic Sans MS",Font.BOLD,30));
        add(heading);

        JLabel teacherlbl = new JLabel("Faculty Name");
        teacherlbl.setBounds(225,200,500,50);
        teacherlbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(teacherlbl);

        teachertxt =new JTextField("Enter Name");
        teachertxt.setBounds(375,200,250,50);
        teachertxt.setFont(new Font("Comic Sans MS",Font.PLAIN,18));
        add(teachertxt);

        JLabel guardianlbl = new JLabel("Guardian Name");
        guardianlbl.setBounds(750,200,500,50);
        guardianlbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(guardianlbl);

        guardiantxt =new JTextField("Enter Guardian Name");
        guardiantxt.setBounds(915,200,250,50);
        guardiantxt.setFont(new Font("Comic Sans MS",Font.PLAIN,18));
        add(guardiantxt);

        JLabel emplbl=new JLabel("Employee ID");
        emplbl.setBounds(225,275,500,50);
        emplbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(emplbl);

        nextEmpNo=generateEmpId();
        emptxt=new JLabel("23E101"+nextEmpNo);
        emptxt.setBounds(375,275,250,50);
        emptxt.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(emptxt);

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

        JLabel qualilbl = new JLabel("Qualification");
        qualilbl.setBounds(225,575,500,50);
        qualilbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(qualilbl);

        String quali[]={"UG","PG","Phd"};
        qualijcb =new JComboBox(quali);
        qualijcb.setBounds(375,575,250,50);
        qualijcb.setFont(new Font("Comic Sans Ms",Font.PLAIN,18));
        qualijcb.setBackground(Color.WHITE);
        add(qualijcb);

        JLabel deplbl=new JLabel("Department");
        deplbl.setBounds(750,575,500,50);
        deplbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(deplbl);

        String dep[]={"B.Tech","BCA","BBA","M.Tech","MCA","MBA"};
        depjcb = new JComboBox(dep);
        depjcb.setBounds(915,575,250,50);
        depjcb.setFont(new Font("Comic Sans MS",Font.PLAIN,18));
        depjcb.setBackground(Color.WHITE);
        add(depjcb);

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

            String name=teachertxt.getText();
            String gname=guardiantxt.getText();
            String emp=emptxt.getText();

            Date date=dcdob.getDate();
            SimpleDateFormat sqlformat= new SimpleDateFormat("yyyy-MM-dd");
            String dob=sqlformat.format(date);

            String address=addresstxt.getText();
            String aadhar=aadhartxt.getText();
            String phone=phonetxt.getText();
            String email=emailtxt.getText();
            String x=xtxt.getText();
            String xii=xiitxt.getText();
            String quali=(String)qualijcb.getSelectedItem();
            String dep=(String)depjcb.getSelectedItem();

            try{

                String query="insert into teacher values('"+nextEmpNo+"','"+name+"','"+gname+"','"+emp+"','"+dob+"','"+address+"','"+aadhar+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+quali+"','"+dep+"')";

                Conn con=new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Teacher Details Submitted Successfully");

                setVisible(false);
                new Project();

            }catch(Exception e){
                e.printStackTrace();
            }


        }
        else if(ae.getSource()==cancel){
            setVisible(false);
            new Project();
        }
        else if(ae.getSource()==exit)
            setVisible(false);

    }

    private long generateEmpId() {
        long nextEmpId = 1; // Initial next employee ID

        try {
            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery("SELECT Emp_No FROM teacher ORDER BY Emp_No ASC");

            // Track the last seen employee ID
            long lastEmpId = 0;

            // Iterate over each employee ID
            while (rs.next()) {
                long empId = rs.getLong("Emp_No");

                // If there's a gap between lastEmpId and the current empId, fill the gap
                if (empId - lastEmpId > 1) {
                    nextEmpId = lastEmpId + 1;
                    break;
                }

                lastEmpId = empId; // Update the last seen employee ID
            }

            // If all employee IDs are occupied, increment the last one by 1
            if (nextEmpId == 1) {
                nextEmpId = lastEmpId + 1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return nextEmpId;
    }

    public static void main(String[] args) {
        new AddTeacher();
    }
}


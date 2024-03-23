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


public class UpdateTeacher extends JFrame implements ActionListener{

    JComboBox qualijcb, depjcb;
    JTextField addresstxt, phonetxt, emailtxt;
    JButton update, delete, cancel, exit;
    Choice cemp;

    UpdateTeacher(){
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

        JLabel heading = new JLabel("Update Faculty Details");
        heading.setBounds(575,125,500,50);
        heading.setFont(new Font("Comic Sans MS",Font.BOLD,30));
        add(heading);

        JLabel srclbl=new JLabel("Search By Emopoyee ID");
        srclbl.setBounds(125,150,200,50);
        srclbl.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        add(srclbl);

        cemp=new Choice();
        cemp.setBounds(325,163,150,50);
        cemp.setFont(new Font("Comic Sans MS",Font.PLAIN,15));
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



        JLabel teacherlbl = new JLabel("Student Name");
        teacherlbl.setBounds(225,200,500,50);
        teacherlbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(teacherlbl);

        JLabel teachertxt =new JLabel();
        teachertxt.setBounds(375,200,250,50);
        teachertxt.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(teachertxt);

        JLabel guardianlbl = new JLabel("Guardian Name");
        guardianlbl.setBounds(750,200,500,50);
        guardianlbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(guardianlbl);

        JLabel guardiantxt =new JLabel();
        guardiantxt.setBounds(915,200,250,50);
        guardiantxt.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(guardiantxt);

        JLabel emplbl=new JLabel("Employee ID");
        emplbl.setBounds(225,275,500,50);
        emplbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(emplbl);

        JLabel emptxt=new JLabel();
        emptxt.setBounds(375,275,250,50);
        emptxt.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(emptxt);

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

        JLabel branchlbl=new JLabel("Branch");
        branchlbl.setBounds(750,575,500,50);
        branchlbl.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        add(branchlbl);

        String dep[]={"B.Tech","BCA","BBA","M.Tech","MCA","MBA"};
        depjcb = new JComboBox(dep);
        depjcb.setBounds(915,575,250,50);
        depjcb.setFont(new Font("Comic Sans MS",Font.PLAIN,18));
        depjcb.setBackground(Color.WHITE);
        add(depjcb);


        try{
            Conn c=new Conn();
            String query="select * from teacher where Emp_ID='"+cemp.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);

            while(rs.next()){
                teachertxt.setText(rs.getString("Name"));
                guardiantxt.setText(rs.getString("Guardian_Name"));
                emptxt.setText(rs.getString("Emp_ID"));
                dobtxt.setText(rs.getString("Date_Of_Birth"));
                addresstxt.setText(rs.getString("Address"));
                aadhartxt.setText(rs.getString("Aadhar_No"));
                phonetxt.setText(rs.getString("Phone_No"));
                emailtxt.setText(rs.getString("Email_Id"));
                xtxt.setText(rs.getString("X_th"));
                xiitxt.setText(rs.getString("XII_th"));
                qualijcb.setSelectedItem(rs.getString("Qualification"));
                depjcb.setSelectedItem(rs.getString("Department"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        cemp.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){

                try{
                    Conn c=new Conn();
                    String query="select * from teacher where Emp_ID='"+cemp.getSelectedItem()+"'";
                    ResultSet rs=c.s.executeQuery(query);

                    while(rs.next()){
                        teachertxt.setText(rs.getString("Name"));
                        guardiantxt.setText(rs.getString("Guardian_Name"));
                        emptxt.setText(rs.getString("Emp_ID"));
                        dobtxt.setText(rs.getString("Date_Of_Birth"));
                        addresstxt.setText(rs.getString("Address"));
                        aadhartxt.setText(rs.getString("Aadhar_No"));
                        phonetxt.setText(rs.getString("Phone_No"));
                        emailtxt.setText(rs.getString("Email_Id"));
                        xtxt.setText(rs.getString("X_th"));
                        xiitxt.setText(rs.getString("XII_th"));
                        qualijcb.setSelectedItem(rs.getString("Qualification"));
                        depjcb.setSelectedItem(rs.getString("Department"));
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
                String quali=(String)qualijcb.getSelectedItem();
                String dep=(String)depjcb.getSelectedItem();
                String emp=cemp.getSelectedItem();

                String query="update teacher set Address='"+add+"',Phone_No='"+phone+"',Email_ID='"+email+"',Qualification='"+quali+"',Department='"+dep+"' where Emp_ID='"+emp+"'";

                Conn c=new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Faculty Details Updated Successfully");

                dispose();
                new Project();

            }catch(Exception e){
                e.printStackTrace();
            }
        }
        String emp=cemp.getSelectedItem();
        if(ae.getSource()==delete){
            try{
                Conn c=new Conn();

                String query="delete from teacher where Emp_ID='"+cemp.getSelectedItem()+"'";

                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,emp+" Data Deleted Successfully");

                dispose();
                new UpdateTeacher();

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
        new UpdateTeacher();
    }
}


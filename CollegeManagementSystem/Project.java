package CollegeManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Project extends JFrame implements ActionListener{


    Project(){
        setSize(1500,800);
        setLocation(25,20);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("CollegeManagementSystem/icons/main.jpg"));
        Image i2=i1.getImage().getScaledInstance(1500, 800, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);

        JMenuBar mb =new JMenuBar();
        mb.setSize(35,45);
        setJMenuBar(mb);

        //New Information
        JMenu newInformation =new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        customizeMenuFont(newInformation);
        mb.add(newInformation);

        JMenuItem facultyInfo=new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        customizeMenuItemFont(facultyInfo);
        newInformation.add(facultyInfo);

        JMenuItem studentInfo=new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        customizeMenuItemFont(studentInfo);
        newInformation.add(studentInfo);

        //View Details
        JMenu viewDetails =new JMenu("View Details");
        viewDetails.setForeground(Color.BLUE);
        customizeMenuItemFont(viewDetails);
        mb.add(viewDetails);

        JMenuItem facultyDetails=new JMenuItem("Faculty Details");
        facultyDetails.setBackground(Color.WHITE);
        facultyDetails.addActionListener(this);
        customizeMenuItemFont(facultyDetails);
        viewDetails.add(facultyDetails);

        JMenuItem studentDetails=new JMenuItem("Student Details");
        studentDetails.setBackground(Color.WHITE);
        studentDetails.addActionListener(this);
        customizeMenuItemFont(studentDetails);
        viewDetails.add(studentDetails);

        //Exam
        JMenu exam =new JMenu("Examination");
        exam.setForeground(Color.BLUE);
        customizeMenuItemFont(exam);
        mb.add(exam);

        JMenuItem viewResult=new JMenuItem("View Result");
        viewResult.setBackground(Color.WHITE);
        viewResult.addActionListener(this);
        customizeMenuItemFont(viewResult);
        exam.add(viewResult);

        JMenuItem addResult=new JMenuItem("Add Result");
        addResult.setBackground(Color.WHITE);
        addResult.addActionListener(this);
        customizeMenuItemFont(addResult);
        exam.add(addResult);

        //Update
        JMenu updateDetails =new JMenu("Update Details");
        updateDetails.setForeground(Color.BLUE);
        customizeMenuItemFont(updateDetails);
        mb.add(updateDetails);

        JMenuItem FacultyDetails=new JMenuItem("Update Faculty Details");
        FacultyDetails.setBackground(Color.WHITE);
        customizeMenuItemFont(FacultyDetails);
        FacultyDetails.addActionListener(this);
        updateDetails.add(FacultyDetails);

        JMenuItem StudentDetails=new JMenuItem("Update Student Details");
        StudentDetails.setBackground(Color.WHITE);
        customizeMenuItemFont(StudentDetails);
        StudentDetails.addActionListener(this);
        updateDetails.add(StudentDetails);

        //fee
        JMenu fee =new JMenu("Fee");
        fee.setForeground(Color.BLUE);
        customizeMenuItemFont(fee);
        mb.add(fee);

        JMenuItem feeStructure=new JMenuItem("Fee Structure");
        feeStructure.setBackground(Color.WHITE);
        feeStructure.addActionListener(this);
        customizeMenuItemFont(feeStructure);
        fee.add(feeStructure);

        JMenuItem feePay=new JMenuItem("Pay Fees");
        feePay.setBackground(Color.WHITE);
        feePay.addActionListener(this);
        customizeMenuItemFont(feePay);
        fee.add(feePay);

        //leave
        JMenu leave =new JMenu("Leave");
        leave.setForeground(Color.BLUE);
        customizeMenuItemFont(leave);
        mb.add(leave);

        JMenuItem facultyLeave=new JMenuItem("Faculty Leave");
        facultyLeave.setBackground(Color.WHITE);
        facultyLeave.addActionListener(this);
        customizeMenuItemFont(facultyLeave);
        leave.add(facultyLeave);

        JMenuItem studentLeave=new JMenuItem("Student Leave");
        studentLeave.setBackground(Color.WHITE);
        studentLeave.addActionListener(this);
        customizeMenuItemFont(studentLeave);
        leave.add(studentLeave);

        //leave Details
        JMenu leaveDetails =new JMenu("Leave Details");
        leaveDetails.setForeground(Color.BLUE);
        customizeMenuItemFont(leaveDetails);
        mb.add(leaveDetails);

        JMenuItem facultyLeaveDetails=new JMenuItem("Faculty Leave Details");
        facultyLeaveDetails.setBackground(Color.WHITE);
        facultyLeaveDetails.addActionListener(this);
        customizeMenuItemFont(facultyLeaveDetails);
        leaveDetails.add(facultyLeaveDetails);

        JMenuItem studentLeaveDetails=new JMenuItem("Student Leave Details");
        studentLeaveDetails.setBackground(Color.WHITE);
        studentLeaveDetails.addActionListener(this);
        customizeMenuItemFont(studentLeaveDetails);
        leaveDetails.add(studentLeaveDetails);

        //about
        JMenu about =new JMenu("About");
        about.setForeground(Color.BLUE);
        customizeMenuItemFont(about);
        mb.add(about);

        JMenuItem abouti=new JMenuItem("About");
        abouti.setBackground(Color.WHITE);
        abouti.addActionListener(this);
        customizeMenuItemFont(abouti);
        about.add(abouti);

        //exit
        JMenu exit =new JMenu("Exit");
        exit.setForeground(Color.BLUE);
        customizeMenuItemFont(exit);
        mb.add(exit);

        JMenuItem exiti=new JMenuItem("Exit");
        exiti.setBackground(Color.WHITE);
        exiti.addActionListener(this);
        customizeMenuItemFont(exiti);
        exit.add(exiti);



        add(image);

        setVisible(true);

    }

    private void customizeMenuFont(JMenu menu) {
        Font font = new Font("Comic Sans MS", Font.BOLD, 14); // Customize font and size
        menu.setFont(font);
    }

    private void customizeMenuItemFont(JMenuItem menu) {
        Font font = new Font("Comic Sans MS", Font.BOLD, 14); // Customize font and size
        menu.setFont(font);
    }

    public void actionPerformed(ActionEvent ae){

        String msg=ae.getActionCommand();

        if(msg.equals("Faculty Details")){
            dispose();
            new TeacherDetails();
        }

        else if(msg.equals("Student Details")){
            dispose();
            new StudentDetails();
        }

        else if(msg.equals("New Faculty Information")){
            dispose();
            new AddTeacher();
        }

        else if(msg.equals("New Student Information")){
            dispose();
            new AddStudent();
        }

        else if(msg.equals("Update Faculty Details")){
            dispose();
            new UpdateTeacher();
        }

        else if(msg.equals("Update Student Details")){
            dispose();
            new UpdateStudent();
        }

        else if(msg.equals("View Result")){
            dispose();
            new ExamDetails();
        }

        else if(msg.equals("Add Result")){
            dispose();
            new EnterMarks();
        }

        else if(msg.equals("Fee Structure")){
            dispose();
            new FeeStructure();
        }

        else if(msg.equals("Pay Fees")){
            dispose();
            new FeeForm();
        }

        else if(msg.equals("Faculty Leave")){
            dispose();
            new TeacherLeave();
        }

        else if(msg.equals("Student Leave")){
            dispose();
            new StudentLeave();
        }

        else if(msg.equals("Faculty Leave Details")){
            dispose();
            new TeacherLeaveDetails();
        }

        else if(msg.equals("Student Leave Details")){
            dispose();
            new StudentLeaveDetails();
        }

        else if(msg.equals("About"))
            new About();

        else if(msg.equals("Exit"))
            setVisible(false);


    }

    public static void main(String[] args) {
        new Project();
    }


}


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class AssistantSection extends JFrame implements ActionListener {
    private Container c;
    private JButton addStudent, viewStudent, editStudent, deleteStudent, logout;
    private JLabel titleMsg;
    private static ArrayList<Student> students = new ArrayList<>();

    public AssistantSection() {
        c = getContentPane();
        c.setLayout(null);
        titleMsg = new JLabel("Assistant Section");
        titleMsg.setBounds(180, 20, 150, 35);
        addStudent = new JButton("Add Student");
        addStudent.setBounds(50, 70, 150, 35);
        addStudent.addActionListener(this);
        viewStudent = new JButton("View Student");
        viewStudent.setBounds(250, 70, 150, 35);
        viewStudent.addActionListener(this);
        editStudent = new JButton("Edit Student");
        editStudent.setBounds(50, 120, 150, 35);
        editStudent.addActionListener(this);
        deleteStudent = new JButton("Delete Student");
        deleteStudent.setBounds(250, 120, 150, 35);
        deleteStudent.addActionListener(this);
        logout = new JButton("Logout");
        logout.setBounds(150, 180, 150, 35);
        logout.addActionListener(this);
        c.add(titleMsg);
        c.add(addStudent);
        c.add(viewStudent);
        c.add(editStudent);
        c.add(deleteStudent);
        c.add(logout);
        setResizable(false);
        setVisible(true);
        setBounds(700,300,480, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static void setStudents(ArrayList<Student> students) {
        AssistantSection.students = students;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addStudent){
            new AddStudent();
            setVisible(false);
        }
        else if(e.getSource() == viewStudent){
            if (students.size() == 0){
                JOptionPane.showMessageDialog(null, "You don't have any student!");
            } else {
                new ViewStudent();
            }
        }
        else if(e.getSource() == editStudent){
            if (students.size() == 0){
                JOptionPane.showMessageDialog(null, "You don't have any student!");
            } else {
                new EditStudent();
                setVisible(false);
            }
        }
        else if(e.getSource() == deleteStudent){
            if (students.size() == 0) {
                JOptionPane.showMessageDialog(null, "You don't have any student!");
            } else {
                new DeleteStudent();
            }
        }
        else {
            new AssistantLogin();
            setVisible(false);
        }
    }
}

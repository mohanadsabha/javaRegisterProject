import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddStudent extends JFrame implements ActionListener{
    private Container c;
    private JLabel titleMsg, l1, l2, l3, l4, l5, l6, l7;
    private JButton add, back;
    private JTextField name, faculty, course, stId, level, stClass;
    private JComboBox labTime;
    private String s[] = {"Saturday 8-10", "Sunday 9-11", "Monday 10-12"};
    public AddStudent(){
        c = getContentPane();
        c.setLayout(null);
        titleMsg = new JLabel("Add Student");
        titleMsg.setBounds(170,20,80,30);
        l1 = new JLabel("Name:");
        l1.setBounds(20,80,80,20);
        l2 = new JLabel("Faculty:");
        l2.setBounds(20,110,80,20);
        l3 = new JLabel("Course:");
        l3.setBounds(20,140,80,20);
        l4 = new JLabel("ID:");
        l4.setBounds(20,170,80,20);
        l5 = new JLabel("Level:");
        l5.setBounds(20,200,80,20);
        l6 = new JLabel("Class:");
        l6.setBounds(20,230,80,20);
        l7 = new JLabel("Lab Time:");
        l7.setBounds(20,260,80,20);
        add =new JButton("Add Student");
        add.setBounds(140,330,150,40);
        add.addActionListener(this);
        back = new JButton("back");
        back.setBounds(300,330,70,30);
        back.addActionListener(this);
        name = new JTextField(30);
        name.setBounds(140,80,200,20);
        faculty = new JTextField(30);
        faculty.setBounds(140,110,200,20);
        course = new JTextField(30);
        course.setBounds(140,140,200,20);
        stId = new JTextField(30);
        stId.setBounds(140,170,200,20);
        level = new JTextField(30);
        level.setBounds(140,200,200,20);
        stClass = new JTextField(40);
        stClass.setBounds(140,230,200,20);
        labTime = new JComboBox(s);
        labTime.setBounds(140,260,200,40);
        c.add(titleMsg);c.add(l1);c.add(l2);c.add(l3);c.add(l4);c.add(l5);c.add(l6);c.add(add);c.add(back);c.add(name);c.add(faculty);c.add(course);
        c.add(stId);c.add(level);c.add(stClass);c.add(labTime);c.add(l7);
        setResizable(false);
        setVisible(true);
        setBounds(700,300,440,450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== add){
            if((name.getText().isEmpty()) || (faculty.getText().isEmpty()) || (course.getText().isEmpty()) || (stId.getText().isEmpty())  || (level.getText().isEmpty()) || (stClass.getText().isEmpty())){
                JOptionPane.showMessageDialog(this, "Empty Field");
            } else {
                try {
                   Integer.parseInt(stId.getText());
                   Integer.parseInt(level.getText());
                   AssistantSection.getStudents().add(new Student(name.getText(), faculty.getText(), course.getText(),
                           stId.getText(), level.getText(), stClass.getText(), (String) labTime.getSelectedItem()));
                    JOptionPane.showMessageDialog(this, "Student added successfully!");
                    name.setText("");
                    faculty.setText("");
                    course.setText("");
                    stId.setText("");
                    level.setText("");
                    stClass.setText("");
                } catch (NumberFormatException exception){
                    JOptionPane.showMessageDialog(this, "ID and level should be only numbers!");
                }
            }
        }
        else {
            new AssistantSection();
            setVisible(false);
        }
    }
}

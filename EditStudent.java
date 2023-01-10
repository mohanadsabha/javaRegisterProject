import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EditStudent extends JFrame implements ActionListener{
    Container c;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JButton updateStudent, back, load;
    JTextField rollNo, name, faculty, course, stId, level, stClass;
    JComboBox labTime;
    String s[] = {"Saturday 8-10", "Sunday 9-11", "Monday 10-12"};
    public EditStudent(){
        c = getContentPane();
        c.setLayout(null);
        l1 = new JLabel("Roll no:");
        l1.setBounds(20,20,80,30);
        l2 = new JLabel("Name:");
        l2.setBounds(20,80,80,20);
        l3 = new JLabel("Faculty:");
        l3.setBounds(20,110,80,20);
        l4 = new JLabel("Course:");
        l4.setBounds(20,140,80,20);
        l5 = new JLabel("ID:");
        l5.setBounds(20,170,80,20);
        l6 = new JLabel("Level:");
        l6.setBounds(20,200,80,20);
        l7 = new JLabel("Class:");
        l7.setBounds(20,230,80,20);
        l8 = new JLabel("Lab Time:");
        l8.setBounds(20,260,80,20);
        updateStudent =new JButton("Update Student");
        updateStudent.setBounds(140,340,150,40);
        updateStudent.addActionListener(this);
        back = new JButton("back");
        back.setBounds(300,345,70,30);
        back.addActionListener(this);
        load = new JButton("Load Record");
        load.setBounds(330,17,110,25);
        load.addActionListener(this);
        rollNo = new JTextField(20);
        rollNo.setBounds(120,20,200,20);
        name = new JTextField(20);
        name.setBounds(120,80,200,20);
        faculty = new JTextField(20);
        faculty.setBounds(120,110,200,20);
        course = new JTextField(20);
        course.setBounds(120,140,200,20);
        stId = new JTextField(20);
        stId.setBounds(120,170,200,20);
        level = new JTextField(20);
        level.setBounds(120,200,200,20);
        stClass = new JTextField(20);
        stClass.setBounds(120,230,200,20);
        labTime = new JComboBox(s);
        labTime.setSelectedIndex(0);
        labTime.setBounds(120,260,200,40);
        c.add(l1);c.add(l2);c.add(l3);c.add(l4);c.add(l5);c.add(l6);c.add(l7);c.add(updateStudent);c.add(back);c.add(rollNo);c.add(name);c.add(faculty);
        c.add(course);c.add(stId);c.add(level);c.add(labTime);c.add(l8);c.add(load);c.add(stClass);
        setVisible(true);
        setResizable(false);
        setBounds(700,300,480,450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    int i = -1;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == load) {
            try {
                int roll = Integer.parseInt(rollNo.getText());
                i = roll - 1;
                if (i < AssistantSection.getStudents().size() && i >= 0){
                    name.setText(AssistantSection.getStudents().get(i).getName());
                    faculty.setText(AssistantSection.getStudents().get(i).getFaculty());
                    course.setText(AssistantSection.getStudents().get(i).getCourse());
                    stId.setText(AssistantSection.getStudents().get(i).getStId());
                    level.setText(AssistantSection.getStudents().get(i).getLevel());
                    stClass.setText(AssistantSection.getStudents().get(i).getStClass());
                    labTime.setSelectedItem(AssistantSection.getStudents().get(i).getLabTime());
                } else {
                    JOptionPane.showMessageDialog(this, "Student not found!");
                }
            } catch (NumberFormatException exception){
                JOptionPane.showMessageDialog(this, "Roll no. must be only numbers!");
            }
        } else if (e.getSource() == updateStudent) {
            if (i < AssistantSection.getStudents().size() && i >= 0) {
                if ((name.getText().isEmpty()) || (faculty.getText().isEmpty()) || (course.getText().isEmpty()) || (stId.getText().isEmpty())
                        || (level.getText().isEmpty()) || (stClass.getText().isEmpty())){
                    JOptionPane.showMessageDialog(this, "Empty Field");
                } else { // update
                    try {
                        Integer.parseInt(stId.getText());
                        Integer.parseInt(level.getText());
                        AssistantSection.getStudents().get(i).setName(name.getText());
                        AssistantSection.getStudents().get(i).setFaculty(faculty.getText());
                        AssistantSection.getStudents().get(i).setCourse(course.getText());
                        AssistantSection.getStudents().get(i).setStId(stId.getText());
                        AssistantSection.getStudents().get(i).setLevel(level.getText());
                        AssistantSection.getStudents().get(i).setLabTime((String) labTime.getSelectedItem());
                        JOptionPane.showMessageDialog(this, "Student updated successfully!");
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
            } else {
                JOptionPane.showMessageDialog(this, "The student is not found!");
            }
        } else {
            new AssistantSection();
            setVisible(false);
        }
    }
}


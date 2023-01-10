import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
public class AddAssistant extends JFrame implements ActionListener {
    Container c;
    JButton addAssistant, back;
    JTextField name, pass, email, contactNo;
    JLabel titleMsg, label_name, label_pass, label_email, label_contact;

    public AddAssistant(){
        c = getContentPane();
        c.setLayout(null);
        titleMsg = new JLabel("Add Assistant");
        titleMsg.setBounds(180,20,150,40);
        label_name = new JLabel("Name:");
        label_name.setBounds(30,80,150,20);
        label_pass = new JLabel("Password:");
        label_pass.setBounds(30,110,150,20);
        label_email = new JLabel("Email:");
        label_email.setBounds(30,140,150,20);
        label_contact = new JLabel("Contact No:");
        label_contact.setBounds(30,170,150,20);
        name =new JTextField(15);
        name.setBounds(150,80,200,20);
        pass =new JTextField(15);
        pass.setBounds(150,110,200,20);
        email =new JTextField(15);
        email.setBounds(150,140,200,20);
        contactNo =new JTextField(15);
        contactNo.setBounds(150,170,200,20);
        addAssistant = new JButton("Add Assistant");
        addAssistant.setBounds(170,215,130,40);
        addAssistant.addActionListener(this);
        back = new JButton("Back");
        back.setBounds(340,220,65,25);
        back.addActionListener(this);
        c.add(addAssistant);c.add(back);c.add(name);c.add(pass);c.add(email);c.add(contactNo);c.add(titleMsg);
        c.add(label_name);c.add(label_pass);c.add(label_email);c.add(label_contact);
        setVisible(true);
        setResizable(false);
        setBounds(700,300,470,320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addAssistant) {
            if (!valEmail(email.getText()) || name.getText().isEmpty() || pass.getText().isEmpty() || contactNo.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "unable to add assistant");
            } else {
                AdminSection.getAssistants().add(new Assistant(name.getText(), pass.getText(), email.getText(), contactNo.getText()));
                JOptionPane.showMessageDialog(this, "Assistant added successfully!");
                name.setText("");
                pass.setText("");
                email.setText("");
                contactNo.setText("");
            }
        } else {
            new AdminSection();
            setVisible(false);
        }
    }

    public static boolean valEmail(String input) {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE); // Compiles the given regular expression into a pattern
        Matcher matcher = emailPat.matcher(input); // creat a matcher object
        return matcher.find();
    }
}

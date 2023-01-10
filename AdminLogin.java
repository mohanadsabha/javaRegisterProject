import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class AdminLogin extends JFrame implements ActionListener {
    private Container c;
    private JLabel label_name, label_pass, titleMsg;
    private JButton login, back;
    private JTextField name;
    private JPasswordField pass;
    public AdminLogin(){
        c = getContentPane();
        c.setLayout(null);
        titleMsg = new JLabel("Admin Login");
        titleMsg.setBounds(210,20,100,20);
        label_name = new JLabel("Name: ");
        label_name.setBounds(90,90,100,20);
        name = new JTextField(); name.setBounds(170,90,200,25);
        label_pass = new JLabel("Password: ");
        label_pass.setBounds(90,130,200,20);
        pass = new JPasswordField(); pass.setBounds(170,130,200,25);
        login = new JButton("login");
        login.setBounds(205,190,90,35);
        login.addActionListener(this);
        back = new JButton("back");
        back.setBounds(320,185,70,30);
        back.addActionListener(this);
        c.add(label_name); c.add(name);
        c.add(label_pass); c.add(pass);
        c.add(titleMsg);
        c.add(login); c.add(back);
        setBounds(700,300,500,350);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            if ((name.getText().equals("admin")) && (pass.getText().equals("admin123"))){
                new AdminSection();
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Sorry, username or password error!", "Login Error", JOptionPane.ERROR_MESSAGE);
                name.setText("");
                pass.setText("");
            }
        } else {
            new Start();
            setVisible(false);
        }
    }
}
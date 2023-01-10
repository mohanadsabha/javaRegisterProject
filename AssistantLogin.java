import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AssistantLogin extends JFrame implements ActionListener {

    private Container c;
    private JLabel label_name, label_pass, titleMsg;
    private JTextField name;
    private JPasswordField pass;
    private JButton login, back;
    public AssistantLogin(){
        c = getContentPane();
        c.setLayout(null);
        titleMsg = new JLabel("Assistant Login");
        titleMsg.setBounds(185, 20,150,30);
        label_name =new JLabel("Name :");
        label_name.setBounds(40,70,100,30);
        label_pass =new JLabel("Password :");
        label_pass.setBounds(40,110,100,30);
        name =new JTextField(15);
        name.setBounds(150,75,150,20);
        name.addActionListener(this);
        pass =new JPasswordField(15);
        pass.setBounds(150,115,150,20);
        pass.addActionListener(this);
        login = new JButton("Login");
        login.setBounds(170,170,90,30);
        login.addActionListener(this);
        back = new JButton("back");
        back.setBounds(300,160,70,30);
        back.addActionListener(this);
        c.add(titleMsg);c.add(label_name);c.add(label_pass);c.add(name);c.add(pass);c.add(login);c.add(back);
        setResizable(false);
        setVisible(true);
        setBounds(700,300,480,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            search:{
            int i;
            int size = AdminSection.getAssistants().size();
                for (i = 0; i < size; i++){
                    if (name.getText().equals(AdminSection.getAssistants().get(i).getName())){
                        if (pass.getText().equals(AdminSection.getAssistants().get(i).getPassword())){
                            new AssistantSection();
                            setVisible(false);
                            break search;
                        }
                    }
                }
                JOptionPane.showMessageDialog(this, "Sorry, user or password error!", "Login error", JOptionPane.ERROR_MESSAGE);
                name.setText("");
                pass.setText("");
            }
        } else {
            new Start();
            setVisible(false);
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start extends JFrame implements ActionListener {
    private Container c;
    private JLabel titleMsg;
    private JButton adminBt, assistantBt;
    public Start() {
        setLayout(null);
        titleMsg = new JLabel("Student Report");
        titleMsg.setBounds(200,10,200,80);
        adminBt = new JButton("Admin Login");
        adminBt.setBounds(150,100,200,40);
        adminBt.addActionListener(this);
        assistantBt = new JButton("Assistant Login");
        assistantBt.setBounds(150,160,200,40);
        assistantBt.addActionListener(this);
        c = getContentPane();
        c.add(titleMsg); c.add(adminBt); c.add(assistantBt);
        setBounds(700,300,500,350);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adminBt) {
            new AdminLogin();
        } else {
            new AssistantLogin();
        }
        setVisible(false);
    }
}

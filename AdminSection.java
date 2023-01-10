import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminSection extends JFrame implements ActionListener {
    private Container c;
    private JLabel titleMsg;
    private JButton addAssis, viewAssis, logout;
    private static ArrayList<Assistant> assistants = new ArrayList<>();
    public AdminSection() {
        setLayout(null);
        titleMsg = new JLabel("Admin Section");
        titleMsg.setBounds(200,10,200,80);
        addAssis = new JButton("Add Assistant");
        addAssis.setBounds(150,100,200,40);
        addAssis.addActionListener(this);
        viewAssis = new JButton("View Assistant");
        viewAssis.setBounds(150,160,200,40);
        viewAssis.addActionListener(this);
        logout = new JButton("Logout");
        logout.setBounds(150,220,200,40);
        logout.addActionListener(this);
        c = getContentPane();
        c.add(titleMsg); c.add(addAssis); c.add(viewAssis); c.add(logout);
        setBounds(700,300,500,350);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static ArrayList<Assistant> getAssistants() {
        return assistants;
    }

    public static void setAssistants(ArrayList<Assistant> assistants) {
        AdminSection.assistants = assistants;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addAssis) {
            new AddAssistant();
            setVisible(false);
        } else if (e.getSource() == viewAssis) {
            if (assistants.size() == 0){
                JOptionPane.showMessageDialog(null, "You don't have any assistants!");
            } else {
                new ViewAssistant();
            }
        } else {
            new AdminLogin();
            setVisible(false);
        }
    }

}

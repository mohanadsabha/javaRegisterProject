import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewAssistant extends JFrame {
    private JScrollPane panel;
    private JTable table;
    private DefaultTableModel tableModel = new DefaultTableModel(null, new String[]{"Id", "Name", "Password", "Email", "ContactNo"})
    {
        public boolean isCellEditable(int row, int column)
        {
            return false;//This causes all cells to be not editable
        }
    };
    public ViewAssistant() {
        table = new JTable(tableModel);
        tableModel.setColumnCount(5);
        int size = AdminSection.getAssistants().size();
        for(int i = 0; i < size; i++){
            Object[] row ={(i+1), AdminSection.getAssistants().get(i).getName(), AdminSection.getAssistants().get(i).getPassword(),
                    AdminSection.getAssistants().get(i).getEmail(), AdminSection.getAssistants().get(i).getContactNumber()};
            tableModel.addRow(row);
        }
        panel = new JScrollPane(table);
        add(panel);
        setVisible(true);
        setResizable(false);
        setBounds(700,300,750,600);
    }


}

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewStudent extends JFrame {
    JScrollPane panel;
    private JTable table;
    private DefaultTableModel tableModel = new DefaultTableModel(null,new String[]{"RollNo", "Name", "Faculty",  "Course", "ID", "Level", "Class", "Lab_Time"})
    {
        public boolean isCellEditable(int row, int column)
        {
            return false;//This causes all cells to be not editable
        }
    };
    public ViewStudent() {
        table = new JTable(tableModel);
        tableModel.setColumnCount(8);
        int size = AssistantSection.getStudents().size();
        for(int i = 0; i < size; i++){
            Object[] row ={(i+1), AssistantSection.getStudents().get(i).getName(), AssistantSection.getStudents().get(i).getFaculty(), AssistantSection.getStudents().get(i).getCourse(),
                    AssistantSection.getStudents().get(i).getStId(), AssistantSection.getStudents().get(i).getLevel(),
                    AssistantSection.getStudents().get(i).getStClass(), AssistantSection.getStudents().get(i).getLabTime()};
            tableModel.addRow(row);
        }
        panel = new JScrollPane(table);
        add(panel);
        setVisible(true);
        setResizable(false);
        setBounds(700,300,750,600);
    }
}

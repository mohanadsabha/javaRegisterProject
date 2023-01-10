import javax.swing.JOptionPane;

public class DeleteStudent {
    public DeleteStudent(){
            String rollNO = JOptionPane.showInputDialog("Enter the roll of the student to delete");
        if ((rollNO != null) && (rollNO.length() > 0)) {
            try {
                int roll = Integer.parseInt(rollNO);
                int i = roll-1;
                if (i < AssistantSection.getStudents().size() && i >= 0){
                    AssistantSection.getStudents().remove(i);
                    JOptionPane.showMessageDialog(null, "The student is deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "The student is not found!");
                }
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Student Roll must be only numbers!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Delete Failed");
        }
    }
}

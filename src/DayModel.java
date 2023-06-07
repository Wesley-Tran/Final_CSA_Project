import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class DayModel extends AbstractTableModel {

    private Object[][] eventArray;


    public DayModel(Day day) {

        if (day.getEvents().size() == 0) {
            eventArray = null;
        } else {
            eventArray = new Object[day.getEvents().size()][3];
            for (Object[] i : eventArray) {
                i[0] = new JCheckBox();
                i[1] = null;
            }
            for (int i = 0; i < day.getEvents().size(); i++) {
                eventArray[i][2] = day.getEvents().get(i);
            }
        }
    }




    @Override
    public int getRowCount() {
        if (eventArray == null) {return 0;}
        return eventArray.length;
    }

    @Override
    public int getColumnCount() {
        if (eventArray == null) {return 0;}
        return eventArray[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (eventArray == null) {return null;}
        return eventArray[rowIndex][columnIndex];
    }
}

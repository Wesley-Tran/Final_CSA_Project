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
                i[0] = false;
                i[1] = "";
            }
            for (int i = 0; i < day.getEvents().size(); i++) {
                eventArray[i][2] = day.getEvents().get(i);
            }
        }
    }


    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        return col != 2;
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

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.TableView;
import java.awt.*;

public class DayModel extends AbstractTableModel implements TableModelListener {

    private Object[][] eventArray;
    private Day day;

    public DayModel(Day day) {
        this.day = day;
        if (day.getEvents().size() == 0) {
            eventArray = null;
        } else {
            eventArray = new Object[day.getEvents().size()][3]; //size + 1
            //String[] headings = {"Time", "Event"};
            //System.arraycopy(headings, 0, eventArray[0], 1, 2);
            //eventArray[0][0] = "Status";
            for (int r = 0; r < day.getEvents().size(); r++) {
                eventArray[r][0] = false;
                eventArray[r][1] = "";
                eventArray[r][2] = day.getEvents().get(r); //r-1
            }
        }
        this.addTableModelListener(this);
    }

    public Day getDay() {return day;}

    @Override
    public Class getColumnClass(int c) {
        //if (c == 0 ) {return Boolean.class;}
        return getValueAt(0, c).getClass();
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        return col != 2;
    }
    @Override
    public void setValueAt(Object value, int row, int col) {
        eventArray[row][col] = value;
        fireTableCellUpdated(row, col);
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

    @Override
    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();


    }

}


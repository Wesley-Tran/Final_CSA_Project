import javax.swing.table.AbstractTableModel;
import java.util.GregorianCalendar;

public class CalendarModel extends AbstractTableModel {

    private final String[] weekdayNames;
    private Object[][] arrModel;
    Day[] days;

    public CalendarModel(Day[] days) {
        this.days = days;
        arrModel = new Object[7][7];
        weekdayNames = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};


        for (int i = 0; i < arrModel[0].length; i++) {
            arrModel[0][i] = weekdayNames[i];
        }

    }

    public void setMonth(int year, String month) {
        for (int i = 1; i < 7; ++i)
            for (int j = 0; j < 7; ++j)
                arrModel[i][j] = null;
        java.util.GregorianCalendar cal = new java.util.GregorianCalendar();
        cal.set(year, Dates.convertToInt(month), 1);
        int offset = cal.get(java.util.GregorianCalendar.DAY_OF_WEEK) - 1;
        offset += 7;
        int num = days.length;
        for (int i = 0; i < num; ++i) {
            arrModel[offset / 7][offset % 7] = Integer.toString(i + 1);
            ++offset;
        }
    }

    @Override
    public int getRowCount() {
        return 7;
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int row, int column) {
        return arrModel[row][column];
    }
}

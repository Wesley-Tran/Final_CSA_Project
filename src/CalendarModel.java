import javax.swing.table.AbstractTableModel;

public class CalendarModel extends AbstractTableModel {

    private final String[] weekdayNames;
    private Object[][] calendar;

    public CalendarModel(Day[] days) {
        calendar = new Object[6][7];
        weekdayNames = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        for (int i = 0; i < calendar[0].length; i++) {
            calendar[0][i] = weekdayNames[i];
        }
        int temp = 0; //find a way to set the days into the correct order and the starting date
        for (int i = 1; i < calendar.length; i++) {
            for (int j = 0; j < calendar[i].length; j++) {
                calendar[i][j] = days[temp];
                temp++;
            }
        }

    }

    @Override
    public int getRowCount() {
        return 6;
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }
}

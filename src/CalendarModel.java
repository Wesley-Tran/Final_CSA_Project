import javax.swing.table.AbstractTableModel;
import java.util.Arrays;

public class CalendarModel extends AbstractTableModel {

    private final String[] weekdayNames;
    private Object[][] arrModel;
    private Day[] days;
    private Calendar tempCal;

    public CalendarModel(Calendar temp) {
        tempCal = temp;
        this.days = temp.getMonth().getAllDays();
        arrModel = new Object[7][7];
        weekdayNames = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};


        for (int i = 0; i < arrModel[0].length; i++) {
            arrModel[0][i] = weekdayNames[i];
        }

    }

    public void setMonth(int year, String month) {
        for (int i = 1; i < 7; ++i) {
            Arrays.fill(arrModel[i], null);
        }
        int offset = days[0].numWeekDay() - 1;
        offset += 7;
        for (Day day : days) {
            arrModel[offset / 7][offset % 7] = day;
            offset++;
        }

    }
    public void setMonth(Calendar temp) { //change the month
        tempCal = temp;
        days = tempCal.getMonth().getAllDays();
        setMonth(days[0].getYear(),days[0].getMonth());
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

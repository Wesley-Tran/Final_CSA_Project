/**
 * Utility class to determine dates from time package and convert month names to numbers
 */
import java.time.LocalDate; //might want to get local time as well idk yet
import java.util.HashMap;
import java.time.Month;


public class Dates {
    public static final LocalDate CURRENT_DATE = LocalDate.now();
    public static final Month MONTH_NAME = CURRENT_DATE.getMonth();
    public static final int MONTH = MONTH_NAME.getValue();
    public static final int YEAR = CURRENT_DATE.getYear();

    public static String[] convertISO(String ISO) {
        String[] arr = new String[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = ISO.substring(0,ISO.indexOf("-"));
            ISO = ISO.substring(ISO.indexOf("-")+1);
        }
        return arr;
    }

    public static String convertMonthName(int monthNum) { //hash map for month num to name (might be a method hat exists)
        HashMap<Integer,String> dayMonth = new HashMap<>();
        dayMonth.put(1,"JANUARY");
        dayMonth.put(2,"FEBRUARY");
        dayMonth.put(3,"MARCH");
        dayMonth.put(4,"APRIL");
        dayMonth.put(5,"MAY");
        dayMonth.put(6,"JUNE");
        dayMonth.put(7,"JULY");
        dayMonth.put(8,"AUGUST");
        dayMonth.put(9,"SEPTEMBER");
        dayMonth.put(10,"OCTOBER");
        dayMonth.put(11,"NOVEMBER");
        dayMonth.put(12,"DECEMBER");
        return dayMonth.get(monthNum);

    }




}

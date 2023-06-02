/**
 * Utility class to determine dates from time package and convert month names to numbers
 */
import java.time.LocalDate; //might want to get local time as well idk yet
import java.util.ArrayList;
import java.util.HashMap;
import java.time.Month;


public class Dates {
    public static final LocalDate CURRENT_DATE = LocalDate.now();
    public static final Month MONTH_NAME = CURRENT_DATE.getMonth();
    public static final int MONTH = MONTH_NAME.getValue();
    public static final int YEAR = CURRENT_DATE.getYear();
    private static ArrayList<Calendar> list = new ArrayList<>();

    public static ArrayList<Calendar> getList() {return list;}

    public static Calendar nextMonth(String month, int year) {
        int temp = Integer.parseInt(month);
        if (temp+1 == 13) {
            temp = 0;
            year += 1;
        }
        return CalendarAPI.getCalender(year,temp+1);
    }
    public static Calendar lastMonth(String month, int year) {
        int temp = Integer.parseInt(month);
        if (temp-1 == 0) {
            temp = 13;
            year -= 1;
        }
        return CalendarAPI.getCalender(year,temp-1);
    }

    public static String[] convertISO(String ISO) {
        String[] arr = new String[3];
        for (int i = 0; i < 2; i++) { //nred to get last value
            arr[i] = ISO.substring(0,ISO.indexOf("-"));
            ISO = ISO.substring(ISO.indexOf("-")+1);
        }
        arr[2] = ISO;
        return arr;
    }

    public static String convertToName(int monthNum) { //hash map for month num to name (might be a method hat exists)
        HashMap<Integer,String> dayMonth = new HashMap<>();
        dayMonth.put(1,"January");
        dayMonth.put(2,"February");
        dayMonth.put(3,"March");
        dayMonth.put(4,"April");
        dayMonth.put(5,"May");
        dayMonth.put(6,"June");
        dayMonth.put(7,"July");
        dayMonth.put(8,"August");
        dayMonth.put(9,"September");
        dayMonth.put(10,"October");
        dayMonth.put(11,"November");
        dayMonth.put(12,"December");
        return dayMonth.get(monthNum);
    }
    public static int convertToInt(String monthName) { //hash map for month num to name (might be a method hat exists)
        HashMap<String,Integer> dayMonth = new HashMap<>();
        dayMonth.put("January",1);
        dayMonth.put("February",2);
        dayMonth.put("March",3);
        dayMonth.put("April",4);
        dayMonth.put("May",5);
        dayMonth.put("June",6);
        dayMonth.put("July",7);
        dayMonth.put("August",8);
        dayMonth.put("September",9);
        dayMonth.put("October",10);
        dayMonth.put("November",11);
        dayMonth.put("December",12);
        return dayMonth.get(monthName.substring(0,1).toUpperCase() + monthName.substring(1).toLowerCase());
    }




}

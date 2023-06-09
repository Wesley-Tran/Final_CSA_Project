import java.util.ArrayList;
import java.util.Calendar;

public class Day {

    private String month; //stored in its number form but it is a String (need to parse int then convert to its name)
    private int day;
    private int year;
    private String weekday;
    private ArrayList<String> events;
    //might wnat a holiday list but not for now?

    public Day(String month,int day, int year,String weekday) {
        this.month = month;
        this.day = day;
        this.year = year;
        this.weekday = weekday;
        events = new ArrayList<>();
    }

    public String getMonth() {return month;}

    public ArrayList<String> getEvents() {return events;}
    public void addEvent(String i) {
        if (!events.contains(i)) {
            events.add(i);
        }
    }

    public int getYear() {return year;}

    public String getWeekDay() {return weekday;}
    public int numWeekDay() {
        return switch (weekday.toLowerCase()) {
            case "sunday" -> java.util.Calendar.SUNDAY;
            case "monday" -> java.util.Calendar.MONDAY;
            case "tuesday" -> java.util.Calendar.TUESDAY;
            case "wednesday" -> java.util.Calendar.WEDNESDAY;
            case "thursday" -> java.util.Calendar.THURSDAY;
            case "friday" -> java.util.Calendar.FRIDAY;
            case "saturday" -> java.util.Calendar.SATURDAY;
            default -> 0;
        };
    }

    @Override
    public String toString() {
        return String.valueOf(day);
    }
}

import java.util.ArrayList;
//might not be necessary
public class Month {

    private ArrayList<Day> days;

    public Month() {
        days = new ArrayList<>();
    }

    public void addDay(Day day) {
        days.add(day);
    }

    //might not need
    public Day[] getAllDays() {
        if (days == null) {return null;}
        Day[] arrDays = new Day[days.size()];
        for (int i = 0; i < days.size(); i++) {
            arrDays[i] = days.get(i);
        }
        return arrDays;
    }

    public Day getDay(int index) {
        if (days != null && index < days.size()) {
            return days.get(index);
        }
        return null;
    }
}

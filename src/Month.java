import java.util.ArrayList;
//might not be necessary
public class Month {

    private ArrayList<Day> days;

    public Month() {days = new ArrayList<>();}

    public void addDay(Day day) {
        days.add(day);
    }

    public Day getDay(int i) {
        if (days != null && i < days.size()) {
            return days.get(i);
        }
        return null;
    }
}

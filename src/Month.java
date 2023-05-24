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

    public Day getDay(int index) {
        if (days != null && index < days.size()) {
            return days.get(index);
        }
        return null;
    }
}

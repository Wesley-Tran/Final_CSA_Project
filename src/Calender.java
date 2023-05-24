import java.util.ArrayList;
import java.util.HashMap;
public class Calender {

    private Month month; //list of days
    private String firstWeekday;

    public Calender(Month month, String firstWeekday) {
        this.month = month;
        this.firstWeekday = firstWeekday;
    }

    public Month getMonth() { //entire month
        return month;
    }

}

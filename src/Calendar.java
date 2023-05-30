public class Calendar {

    private Month month; //list of days
    private final String firstWeekday;

    public Calendar(Month month, String firstWeekday) {
        this.month = month;
        this.firstWeekday = firstWeekday;
    }

    public Month getMonth() { //entire month
        return month;
    }

    public String getFirstWeekday() {return firstWeekday;}
}

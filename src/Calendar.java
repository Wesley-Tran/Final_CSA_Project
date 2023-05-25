public class Calendar {

    private Month month; //list of days
    private String firstWeekday;

    public Calendar(Month month, String firstWeekday) {
        this.month = month;
        this.firstWeekday = firstWeekday;
    }

    public Month getMonth() { //entire month
        return month;
    }

}

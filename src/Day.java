public class Day {

    private String month; //stored in its number form but it is a String (need to parse int then convert to its name)
    private int day;
    private int year;
    private String weekday;
    //might wnat a holiday list but not for now?

    public Day(String month,int day, int year,String weekday) {
        this.month = month;
        this.day = day;
        this.year = year;
        this.weekday = weekday;
    }

    public String getMonth() {return month;}
    public int getDay() {return day;}
    public int getYear() {return year;}

    public String getWeekDay() {return weekday;}

    @Override
    public String toString() {
        return year + "-" + day + "-" + month;
    }
}

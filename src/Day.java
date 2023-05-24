public class Day {

    private String month;
    private int day;
    private int year;
    //might wnat a holiday list but not for now?

    public Day(String month,int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public String getMonth() {return month;}
    public int getDay() {return day;}
    public int getYear() {return year;}
}

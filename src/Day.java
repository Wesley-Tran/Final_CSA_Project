public class Day {

    private String month;
    private int day;
    private int year;
    private String weekDay;
    //might wnat a holiday list but not for now?

    public Day(String month,int day, int year,String weekDay) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public String getMonth() {return month;}
    public int getDay() {return day;}
    public int getYear() {return year;}

    public String getWeekDay() {return weekDay;}
}

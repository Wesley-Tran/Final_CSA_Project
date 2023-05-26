import javax.swing.*;
import java.awt.*;

public class CalendarGUI extends JFrame{
    private JPanel mainPanel;
    private JLabel mainLabel;
    private JPanel calendarPanel;
    private JPanel sidePanel;
    private JButton addEvent;
    private JTextField eventMon;
    private JTextField eventDay;
    private JTextField eventYear;
    private JTextField calendarMon;
    private JButton left;
    private JButton right;
    private JTextField calendarYear;
    private Calendar calendar;

    private CalendarModel model;

    private JTable calendarDisplay;

    public CalendarGUI() {
        createUIComponents();
    }
    //need to initialize the first calendar to MONTH and YEAR
    private void createUIComponents() {
        calendar = CalendarAPI.getCalender(Dates.YEAR, Dates.MONTH);
        model = new CalendarModel(calendar.getMonth().getAllDays());
        setContentPane(mainPanel);
        setTitle("Insert Calender App Name: ");
        setSize(1200, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        //calendarDisplay = new JTable(model);
        calendarDisplay.setModel(model);
        setLocationByPlatform(true); //
        String month = calendar.getMonth().getDay(0).getMonth();
        int year = calendar.getMonth().getDay(0).getYear();
        calendarMon.setText(month);
        calendarYear.setText(Integer.toString(year));
        model.setMonth(year,Dates.convertToName(Integer.parseInt(month)));
        calendarDisplay.setShowGrid(true);
        calendarDisplay.setGridColor(Color.BLACK);
        //listeners

    }
}
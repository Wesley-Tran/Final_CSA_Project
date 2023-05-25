import javax.swing.*;

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
    private JTable calendarDisplay;
    private Calendar calendar = CalendarAPI.getCalender(Dates.YEAR, Dates.MONTH);;
    private CalendarModel model = new CalendarModel(calendar.getMonth().getAllDays());

    public CalendarGUI() {
        createUIComponents();
    }
    //need to initialize the first calendar to MONTH and YEAR
    private void createUIComponents() {
        setContentPane(mainPanel);
        setTitle("Insert Calender App Name: ");
        setSize(1200, 500);
        setLocationByPlatform(true); //
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        calendarMon.setText(calendar.getMonth().getDay(0).getMonth());
        calendarYear.setText(Integer.toString(calendar.getMonth().getDay(0).getYear()));
        calendarMon.setVisible(true);
        calendarYear.setVisible(true);
        //listeners
        setVisible(true);
    }
}
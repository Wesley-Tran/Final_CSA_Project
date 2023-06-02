import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CalendarGUI extends JFrame implements MouseListener, ActionListener {
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
        model = new CalendarModel(calendar);
        setContentPane(mainPanel);
        setTitle("Insert Calender App Name: ");
        setSize(1200, 580);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        calendarDisplay.setModel(model);
        calendarDisplay.setRowHeight(80);
        calendarDisplay.setRowHeight(0,20);
        //calendarDisplay.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        String month = calendar.getMonth().getDay(0).getMonth();
        int year = calendar.getMonth().getDay(0).getYear();
        calendarMon.setText(month);
        calendarYear.setText(Integer.toString(year));
        model.setMonth(year,Dates.convertToName(Integer.parseInt(month)));
        calendarDisplay.setShowGrid(true);
        calendarDisplay.setGridColor(Color.BLACK);
        //listeners
        calendarDisplay.addMouseListener(this);
        left.addActionListener(this);
        right.addActionListener(this);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            //if point is in the display object's size then u can get the row and column at the point using Jtable's method
            int row = calendarDisplay.getSelectedRow();
            if (row != 0) { //dont use weekdays
                int column = calendarDisplay.getSelectedColumn();
                //call a method to create a new window and pass in the day that was clicked
                //System.out.println(calendarDisplay.getValueAt(row,column));


            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton button) {
            if (button.getText().equals("⬅")) { //need to put in code to check the getList() to see if month was created already
                Dates.getList().add(calendar);
                calendar = Dates.lastMonth(calendar.getMonth().getDay(0).getMonth(),
                                           calendar.getMonth().getDay(0).getYear());
                model.setMonth(calendar);
                calendarDisplay.setModel(model);
                calendarDisplay.repaint();
            } else if (button.getText().equals("➡")) {
                Dates.getList().add(calendar);
                calendar = Dates.nextMonth(calendar.getMonth().getDay(0).getMonth(),
                        calendar.getMonth().getDay(0).getYear());
                model.setMonth(calendar);
                calendarDisplay.setModel(model);
                calendarDisplay.repaint();
            }
        }
    }
}
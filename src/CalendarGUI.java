import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalendarGUI extends JFrame implements MouseListener, ActionListener, FocusListener {
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
    private JPanel dayPanel;
    private JLabel dayName;
    private JTable dayTable;
    private JTextPane eventPanel;
    private String lastMon;

    public CalendarGUI() {
        createUIComponents();
    }
    //need to initialize the first calendar to MONTH and YEAR
    private void createUIComponents() {
        calendar = CalendarAPI.getCalender(Dates.YEAR, Dates.MONTH);
        model = new CalendarModel(calendar);
        setContentPane(mainPanel);
        setTitle("Insert Calender App Name: ");
        setSize(900, 580);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        calendarDisplay.setModel(model);
        calendarDisplay.setRowHeight(80);
        calendarDisplay.setRowHeight(0,20);

        eventMon.setName("eventMon");
        eventDay.setName("eventDay");
        eventYear.setName("eventYear");
        //calendarDisplay.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        lastMon = calendar.getMonth().getDay(0).getMonth();
        int year = calendar.getMonth().getDay(0).getYear();
        calendarMon.setText(lastMon);
        calendarYear.setText(Integer.toString(year));
        model.setMonth(year,Dates.convertToName(Integer.parseInt(lastMon)));
        calendarDisplay.setShowGrid(true);
        calendarDisplay.setGridColor(Color.BLACK);
        //listeners
        calendarDisplay.addMouseListener(this);
        left.addActionListener(this);
        right.addActionListener(this);
        calendarMon.addFocusListener(this);
        calendarYear.addFocusListener(this);
        eventMon.addFocusListener(this);
        eventYear.addFocusListener(this);
        eventDay.addFocusListener(this);
        addEvent.addActionListener(this);
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
                changeMonth(false);
            } else if (button.getText().equals("➡")) {
                changeMonth(true);
            } else if (button.getText().equals("Add")) {

            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        Object source = e.getSource();
        if (source instanceof JTextField textField) {
            String text = textField.getText();
            switch (text) {
                case "Month" -> eventMon.setText("");
                case "Day" -> eventDay.setText("");
                case "Year" -> eventYear.setText("");
            }
        } else {
            lastMon = calendarMon.getText();
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object source = e.getSource();
        if (source instanceof JTextField textField) {
            String text = textField.getName();
            switch (text) {
                case "eventMon" -> eventMon.setText("Month");
                case "eventDay" -> eventDay.setText("Day");
                case "eventYear" -> eventYear.setText("Year");
            }
        } else {
            int tempMon = Integer.parseInt(calendarMon.getText());
            if (tempMon > 12 || tempMon < 1) {calendarMon.setText(lastMon);}
            else{changeMonth(calendarYear.getText(),tempMon);}
        }
    }
    private void changeMonth(boolean next) {
        Dates.getList().add(calendar);
        if (next) {
            calendar = Dates.nextMonth(calendar.getMonth().getDay(0).getMonth(),
                    calendar.getMonth().getDay(0).getYear());
        } else {
            calendar = Dates.lastMonth(calendar.getMonth().getDay(0).getMonth(),
                    calendar.getMonth().getDay(0).getYear());
        }
        calendarMon.setText(calendar.getMonth().getDay(0).getMonth());
        calendarYear.setText("" + calendar.getMonth().getDay(0).getYear());
        model.setMonth(calendar);
        calendarDisplay.setModel(model);
        calendarDisplay.repaint();
    }

    private void changeMonth(String year, int month) {
        Dates.getList().add(calendar);
        for (Calendar cal : Dates.getList()) {
            Day day = cal.getMonth().getDay(0);
            if (Integer.parseInt(day.getMonth()) == month && day.getYear() == Integer.parseInt(year)) {
                Dates.getList().remove(Dates.getList().size()-1);
                model.setMonth(cal);
                calendarDisplay.setModel(model);
                calendarDisplay.repaint();
                return;
            }
        }
        model.setMonth(CalendarAPI.getCalender(Integer.parseInt(year), month));
        calendarDisplay.setModel(model);
        calendarDisplay.repaint();
    }
}
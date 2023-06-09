import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

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

    private DayModel dayModel;
    private JTextPane eventPanel;
    private String lastMon;

    public CalendarGUI() {
        createUIComponents();
    }
    //need to initialize the first calendar to MONTH and YEAR
    private void createUIComponents() {
        calendar = CalendarAPI.getCalender(Dates.YEAR, Dates.MONTH);
        Dates.getList().add(calendar);
        model = new CalendarModel(calendar);
        setContentPane(mainPanel);
        setTitle("Insert Calender App Name: ");
        setSize(900, 580);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        calendarDisplay.setModel(model);
        calendarDisplay.setRowHeight(80);
        calendarDisplay.setRowHeight(0,20);

        dayTable.setShowGrid(false);

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
            int row = calendarDisplay.getSelectedRow();
            if (row != 0) { //dont use weekdays
                int column = calendarDisplay.getSelectedColumn();
                System.out.println(calendarDisplay.getValueAt(row,column));
                System.out.println(((Day) calendarDisplay.getValueAt(row,column)).getEvents());
                dayModel = new DayModel((Day) calendarDisplay.getValueAt(row,column));
                dayTable.setModel(dayModel);
                dayTable.repaint();


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
            } else if (button.getText().equals("Add")) { //event is not being added to the day correctly (maybe something wrong with reference bewteen calendars?)
                Calendar cal = Dates.containsCal(eventMon.getText(), eventYear.getText());
                System.out.println(eventMon.getText() + " and " + eventYear.getText());
                System.out.println(calendar);
                System.out.println(cal);
                cal.getMonth().getDay(Integer.parseInt(eventDay.getText())-1).addEvent(eventPanel.getText());
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        Object source = e.getSource();
        if (source instanceof JTextField textField) {
            String text = textField.getText();
            switch (text) {
                case "Month Num" -> eventMon.setText("");
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
            if (text == null) {
                int tempMon = Integer.parseInt(calendarMon.getText());
                if (tempMon > 12 || tempMon < 1) {calendarMon.setText(lastMon);}
                else{changeMonth(calendarYear.getText(),tempMon);}
            } else {
                switch (text) {
                    case "eventMon":
                        String tempMon = eventMon.getText();
                        if (tempMon.equals("") || (Integer.parseInt(tempMon) > 12 || Integer.parseInt(tempMon) < 1)) {
                            eventMon.setText("Month Num");
                        }
                    case "eventDay":
                        String tempDay = eventDay.getText();
                        try {
                            if (tempDay.equals("") || (Integer.parseInt(tempDay) > 31 || Integer.parseInt(tempDay) < 1)) {
                                eventDay.setText("Day");
                            }
                        } catch (Exception ignored) {
                            eventDay.setText("Day");
                        }
                    case "eventYear":
                        String tempYear = eventYear.getText();
                        if (tempYear.equals("")) { // || (Integer.parseInt(tempYear) > 12 || Integer.parseInt(tempYear) < 1)
                            eventYear.setText("Year");
                        }
                }
            }
        }
    }
    private void changeMonth(boolean next) {
        Dates.getList().add(calendar);
        if (next) { //next month is wrong
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
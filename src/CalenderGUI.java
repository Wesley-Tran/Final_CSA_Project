import javax.swing.*;

public class CalenderGUI extends JFrame{
    private JPanel mainPanel;
    private JLabel mainLabel;
    private JPanel calenderPanel;
    private JPanel sidePanel;
    private JButton addEvent;
    private JTextField eventMon;
    private JTextField eventDay;
    private JTextField eventYear;
    private JTextField calenderMon;
    private JButton left;
    private JButton right;
    private JTextField calenderYear;
    private JTable calender;

    public CalenderGUI() {
        createUIComponents();
    }
    //need to initialize the first calender to MONTH and YEAR
    private void createUIComponents() {
        setContentPane(mainPanel);
        setTitle("Insert Calender App Name: ");
        setSize(1200, 500);
        setLocationByPlatform(true); //
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //listeners
        setVisible(true);
    }
}

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyGamesPage extends JFrame {

    public MyGamesPage() {
        setTitle("Sudoku - About Us");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 800); // Set the size to 800x800
        setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel(new BorderLayout());

        // Create a table to display the data
        String[] columnNames = {"Description"};
        Object[][] data = {
            {"Project: Sudoku"},
            {"We developed this application for our summer internship project with a team of 4 members.Sudoku is a classic puzzle game that enhances analytical skills."},
            {"Team Members:"},
            {"1.T.Raghavendra Sai Kumar - Registration Number 21B91A05V5"},
            {"2.Y.Swamy Venkata Ajith Kumar  2 - Registration Number 22B95A0530"},
            {"3.P. Khadar Mastan - Registration Number 22B95A0523"},
            {"4.D.Ajay Kumar 4 - Registration Number 22B95A0508"},
            {"College: Sagi Rama Krishnam Raju Engineering College Bhimavaram"}
        };
        JTable table = new JTable(data, columnNames);
        table.setFont(new Font("SansSerif", Font.PLAIN, 16));

        // Set the table's appearance
        table.setRowHeight(30);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        add(contentPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyGamesPage recordsPage = new MyGamesPage();
            recordsPage.setVisible(true);
        });
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HowToPlayPage extends JFrame {
    public HowToPlayPage() {
        setTitle("How to Play Sudoku");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null); // Center the frame on the screen

        JPanel contentPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel headingLabel = new JLabel("How to Play Sudoku?");
        headingLabel.setFont(new Font("SansSerif", Font.BOLD, 36));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2; // Span two columns
        contentPanel.add(headingLabel, constraints);

        // Instruction 1
        JLabel instruction1 = new JLabel("Sudoku is a fun puzzle game.");
        instruction1.setFont(new Font("SansSerif", Font.PLAIN, 24));
        constraints.gridy = 1;
        contentPanel.add(instruction1, constraints);

        // Instruction 2
        JLabel instruction2 = new JLabel("You need to fill in the empty boxes.");
        instruction2.setFont(new Font("SansSerif", Font.PLAIN, 24));
        constraints.gridy = 2;
        contentPanel.add(instruction2, constraints);

        // Instruction 3
        JLabel instruction3 = new JLabel("Each box must have a number from 1 to 9.");
        instruction3.setFont(new Font("SansSerif", Font.PLAIN, 24));
        constraints.gridy = 3;
        contentPanel.add(instruction3, constraints);

        // Instruction 4
        JLabel instruction4 = new JLabel("Make sure no number repeats in a row or column.");
        instruction4.setFont(new Font("SansSerif", Font.PLAIN, 24));
        constraints.gridy = 4;
        contentPanel.add(instruction4, constraints);

        // Instruction 5
        JLabel instruction5 = new JLabel("Have fun and enjoy the game!");
        instruction5.setFont(new Font("SansSerif", Font.PLAIN, 24));
        constraints.gridy = 5;
        contentPanel.add(instruction5, constraints);

        // Add everything to the frame
        add(contentPanel);

        // You can add more instructions as needed.

        // You can also add buttons for navigation, but this example is for instructions.

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HowToPlayPage howToPlayPage = new HowToPlayPage();
                howToPlayPage.setVisible(true);
            }
        });
    }
}

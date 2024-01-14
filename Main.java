import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame();
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Sudoku"); // Set the title to "Sudoku"

        // Create a JPanel for the content
        JPanel contentPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        // Create the heading label
        JLabel headingLabel = new JLabel("Sudoku");
        headingLabel.setFont(new Font("SansSerif", Font.BOLD, 48));
        constraints.gridx = 0;
        constraints.gridy = 0;
        contentPanel.add(headingLabel, constraints);

        // Create the caption label
        JLabel captionLabel = new JLabel("Master your mind");
        captionLabel.setFont(new Font("SansSerif", Font.PLAIN, 24));
        constraints.gridy = 1;
        contentPanel.add(captionLabel, constraints);

        // Create a JPanel for the button
        JPanel buttonPanel = new JPanel();
        JButton startButton = new JButton("Start");
        startButton.setFont(new Font("SansSerif", Font.PLAIN, 24));
        buttonPanel.add(startButton);
        constraints.gridy = 2;
        contentPanel.add(buttonPanel, constraints);

        // Add the content panel to the frame
        frame.add(contentPanel);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Display the frame
        frame.setVisible(true);

        // Add an ActionListener to the Start button
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create and display the Info page
                InfoPage infoPage = new InfoPage();
                infoPage.setVisible(true);
            }
        });
    }
}

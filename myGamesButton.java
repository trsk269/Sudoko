import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myGamesButton extends JFrame {

    public myGamesButton() {
        setTitle("Sudoku - Records");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null); // Center the frame on the screen

        JPanel contentPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        // Add the project name
        JLabel projectNameLabel = new JLabel("Project: Sudoku");
        projectNameLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        projectNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        constraints.gridx = 0;
        constraints.gridy = 0;
        contentPanel.add(projectNameLabel, constraints);

        // Add a paragraph describing the project
        String projectDescription = "We developed this application for our summer internship project with a team of 4 members. Sudoku is a classic puzzle game that enhances analytical skills.";
        JLabel projectDescriptionLabel = new JLabel("<html><p align='center'>" + projectDescription + "</p></html>");
        projectDescriptionLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        constraints.gridy = 1;
        contentPanel.add(projectDescriptionLabel, constraints);

        // Add team member names, registration numbers, and college name
        String teamMembers = "Team Members:\n" +
                "1. Member 1 - Registration Number 12345\n" +
                "2. Member 2 - Registration Number 67890\n" +
                "3. Member 3 - Registration Number 11111\n" +
                "4. Member 4 - Registration Number 22222\n" +
                "College: Sagi Rama Krishnam Raju Engineering College Bhimavaram";
        JLabel teamMembersLabel = new JLabel("<html><p align='center'>" + teamMembers + "</p></html>");
        teamMembersLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        constraints.gridy = 2;
        contentPanel.add(teamMembersLabel, constraints);

        add(contentPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	myGamesButton recordsPage = new myGamesButton();
            recordsPage.setVisible(true);
        });
    }
}

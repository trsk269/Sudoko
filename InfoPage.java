import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoPage extends JFrame {

    public InfoPage() {
        setTitle("Sudoku - Info");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null); // Center the frame on the screen

        JPanel contentPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel headingLabel = new JLabel("Sudoku");
        headingLabel.setFont(new Font("SansSerif", Font.BOLD, 48));
        constraints.gridx = 0;
        constraints.gridy = 0;
        contentPanel.add(headingLabel, constraints);

        JLabel captionLabel = new JLabel("Master your mind");
        captionLabel.setFont(new Font("SansSerif", Font.PLAIN, 24));
        constraints.gridy = 1;
        contentPanel.add(captionLabel, constraints);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 10, 10)); // Five buttons vertically
        JButton easyButton = new JButton("Easy");
        easyButton.setFont(new Font("SansSerif", Font.PLAIN, 24));
        JButton mediumButton = new JButton("Medium");
        mediumButton.setFont(new Font("SansSerif", Font.PLAIN, 24));
        JButton hardButton = new JButton("Hard");
        hardButton.setFont(new Font("SansSerif", Font.PLAIN, 24));
        JButton howToPlayButton = new JButton("How to play");
        howToPlayButton.setFont(new Font("SansSerif", Font.PLAIN, 24));
        JButton myGamesButton = new JButton("About Us");
        myGamesButton.setFont(new Font("SansSerif", Font.PLAIN, 24));

        buttonPanel.add(easyButton);
        buttonPanel.add(mediumButton);
        buttonPanel.add(hardButton);
        buttonPanel.add(howToPlayButton);
        buttonPanel.add(myGamesButton);


        constraints.gridy = 2;
        contentPanel.add(buttonPanel, constraints);

        add(contentPanel);

        // Button ActionListeners go here

        // For My Games button, you can open another page:
        myGamesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyGamesPage myGamesPage = new MyGamesPage();
                myGamesPage.setVisible(true);
            }
        });
        
        howToPlayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	HowToPlayPage howToPlayButton = new HowToPlayPage();
            	howToPlayButton.setVisible(true);
            }
        });

        // For Easy button, open the EasyPage:
        easyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EasyPage easyPage = new EasyPage();
                easyPage.setVisible(true);
            }
        });
        
     
     // For Medium button, open the MediumPage:
        mediumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MediumPage mediumPage = new MediumPage();
                mediumPage.setVisible(true);
            }
        });

        // For Hard button, open the HardPage:
        hardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HardPage hardPage = new HardPage();
                hardPage.setVisible(true);
            }
        });

        // For My Games button, open the MyGamesPage:
        myGamesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyGamesPage myGamesPage = new MyGamesPage();
                myGamesPage.setVisible(true);
            }
        });




        
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                InfoPage infoPage = new InfoPage();
                infoPage.setVisible(true);
            }
        });
    }
}

import javax.swing.*;

public class GameCompletionAlert {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Simulate a successful game completion
            boolean gameCompleted = true;

            if (gameCompleted) {
                // Display an alert for successful game completion
                JOptionPane.showMessageDialog(
                    null, 
                    "Congratulations! You have successfully completed the game.", 
                    "Game Completed", 
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
    }
}

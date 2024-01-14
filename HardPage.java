import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class HardPage extends JFrame {
    // Define the Sudoku puzzle as a 9x9 grid
	private int[][] puzzle = {
		    {0, 0, 0, 0, 0, 0, 0, 0, 5},
		    {9, 0, 6, 0, 0, 0, 0, 0, 0},
		    {0, 3, 0, 0, 0, 0, 8, 0, 0},
		    {0, 5, 0, 0, 6, 0, 0, 0, 0},
		    {0, 0, 2, 8, 0, 0, 0, 0, 0},
		    {0, 0, 0, 0, 0, 4, 0, 7, 0},
		    {0, 0, 0, 0, 0, 0, 0, 0, 0},
		    {0, 0, 7, 0, 0, 1, 0, 0, 0},
		    {0, 0, 0, 0, 0, 0, 0, 0, 0}
		};

		// Define the solution to the puzzle
		private int[][] solution = {
		    {8, 7, 4, 9, 3, 2, 6, 1, 5},
		    {9, 2, 6, 7, 1, 8, 3, 5, 4},
		    {1, 3, 5, 4, 6, 7, 8, 2, 9},
		    {2, 5, 8, 3, 9, 6, 4, 4, 7},
		    {4, 1, 2, 8, 7, 5, 9, 6, 3},
		    {6, 9, 7, 2, 4, 1, 5, 3, 8},
		    {5, 6, 3, 1, 8, 9, 7, 4, 2},
		    {3, 4, 9, 5, 2, 7, 1, 8, 6},
		    {7, 8, 1, 6, 5, 3, 2, 9, 4}
		};


    private JTextField[][] gridCells = new JTextField[9][9];
    private int mistakeCount = 0;

    public HardPage() {
        setTitle("Sudoku - Hard");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel(new BorderLayout());
        JPanel sudokuPanel = new JPanel(new GridLayout(9, 9));

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                gridCells[row][col] = new JTextField(2);
                gridCells[row][col].setHorizontalAlignment(JTextField.CENTER);
                if (puzzle[row][col] != 0) {
                    gridCells[row][col].setText(Integer.toString(puzzle[row][col]));
                    gridCells[row][col].setEditable(false);
                }
                gridCells[row][col].setFont(new Font("SansSerif", Font.PLAIN, 20));
                gridCells[row][col].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                gridCells[row][col].addFocusListener(new SudokuFocusListener(row, col));

                sudokuPanel.add(gridCells[row][col]);
            }
        }

        contentPanel.add(sudokuPanel, BorderLayout.CENTER);
        add(contentPanel);
    }

    private boolean checkSudoku() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                String value = gridCells[row][col].getText();
                if (!value.isEmpty()) {
                    int enteredValue = Integer.parseInt(value);
                    if (enteredValue != solution[row][col]) {
                        return false; // The entered value doesn't match the solution
                    }
                }
            }
        }
        return true; // All entered values match the solution
    }

    private class SudokuFocusListener implements FocusListener {
        private int row;
        private int col;

        public SudokuFocusListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void focusGained(FocusEvent e) {
            // No action needed when focus is gained
        }

        @Override
        public void focusLost(FocusEvent e) {
            String value = gridCells[row][col].getText();
            if (!value.isEmpty()) {
                int enteredValue = Integer.parseInt(value);
                if (enteredValue != solution[row][col]) {
                    mistakeCount++;
                    JOptionPane.showMessageDialog(HardPage.this, "Wrong value entered!");
                    gridCells[row][col].setText("");
                }

                if (mistakeCount >= 3) {
                    // Transition to the game-over page
                    JOptionPane.showMessageDialog(HardPage.this, "Game Over - Three mistakes!");
                    // Add your code to navigate to the game-over page here.
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HardPage hardPage = new HardPage();
            hardPage.setVisible(true);
        });
    }
}

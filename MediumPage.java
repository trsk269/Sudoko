import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class MediumPage extends JFrame {
	private int[][] mediumPuzzle = {
		    {0, 0, 0, 0, 0, 0, 0, 7, 0},
		    {0, 0, 7, 0, 0, 0, 9, 0, 0},
		    {0, 0, 0, 0, 0, 0, 4, 0, 0},
		    {0, 0, 0, 8, 0, 0, 0, 0, 0},
		    {0, 6, 0, 0, 0, 0, 0, 0, 0},
		    {0, 0, 0, 0, 0, 0, 0, 5, 3},
		    {2, 0, 0, 0, 8, 0, 0, 0, 0},
		    {0, 0, 9, 0, 0, 0, 0, 0, 0},
		    {0, 0, 3, 5, 0, 0, 0, 6, 0}
		};


	private int[][] mediumSolution = {
		    {1, 5, 4, 6, 3, 9, 8, 7, 2},
		    {8, 3, 7, 4, 2, 5, 9, 1, 6},
		    {9, 6, 2, 7, 1, 8, 4, 3, 5},
		    {6, 7, 5, 8, 9, 2, 3, 4, 1},
		    {3, 4, 1, 5, 6, 7, 2, 8, 9},
		    {2, 8, 9, 1, 4, 3, 6, 5, 7},
		    {7, 1, 6, 3, 8, 4, 5, 9, 2},
		    {5, 2, 3, 9, 7, 6, 1, 4, 8},
		    {4, 9, 8, 2, 5, 1, 7, 6, 3}
		};


    private JTextField[][] gridCells = new JTextField[9][9];
    private int mistakeCount = 0;

    public MediumPage() {
        setTitle("Sudoku - Medium");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel(new BorderLayout());
        JPanel sudokuPanel = new JPanel(new GridLayout(9, 9));

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                gridCells[row][col] = new JTextField(2);
                gridCells[row][col].setHorizontalAlignment(JTextField.CENTER);
                if (mediumPuzzle[row][col] != 0) {
                    gridCells[row][col].setText(Integer.toString(mediumPuzzle[row][col]));
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
                    if (enteredValue != mediumSolution[row][col]) {
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
                if (enteredValue != mediumSolution[row][col]) {
                    mistakeCount++;
                    JOptionPane.showMessageDialog(MediumPage.this, "Wrong value entered!");
                    gridCells[row][col].setText("");
                }

                if (mistakeCount >= 3) {
                    // Transition to the game-over page
                    JOptionPane.showMessageDialog(MediumPage.this, "Game Over - Three mistakes!");
                    // Add your code to navigate to the game-over page here.
                    
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MediumPage mediumPage = new MediumPage();
            mediumPage.setVisible(true);
        });
    }
}

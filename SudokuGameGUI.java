import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
//https://github.com/JuliaSzymanska/Sudoku_Game.git
//https://github.com/ChudasamaJignesh/Sudoku-v3.0.git
public class SudokuGameGUI extends JFrame implements ActionListener {
    private static final int SIZE = 9;
    private static final int CELL_SIZE = 50;
    private static final int BOARD_SIZE = CELL_SIZE * SIZE;

    private JTextField[][] cells;
    private int[][] initialGrid;

    public SudokuGameGUI(int[][] initialGrid) {
        setTitle("Sudoku Game");
        setSize(BOARD_SIZE, BOARD_SIZE + 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        this.initialGrid = copyGrid(initialGrid); 
        cells = new JTextField[SIZE][SIZE];

        int startX = 10;
        int startY = 10;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j] = new JTextField();
                cells[i][j].setFont(new Font("Arial", Font.PLAIN, 20));
                cells[i][j].setHorizontalAlignment(JTextField.CENTER);
                cells[i][j].setText(initialGrid[i][j] == 0 ? "" : String.valueOf(initialGrid[i][j]));

                int x = startX + j * CELL_SIZE;
                int y = startY + i * CELL_SIZE;
                cells[i][j].setBounds(x, y, CELL_SIZE, CELL_SIZE);
                cells[i][j].addFocusListener(new SudokuFocusListener(i, j));

                add(cells[i][j]);
            }
        }

        JButton solveButton = new JButton("Solve");
        solveButton.addActionListener(this);
        solveButton.setBounds(10, BOARD_SIZE + 10, 100, 30);
        add(solveButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Solve")) {
            solveSudoku();
        }
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
        }

        @Override
        public void focusLost(FocusEvent e) {
            String text = cells[row][col].getText();
            try {
                int value = Integer.parseInt(text);
                if (value >= 1 && value <= 9) {
                    if (isValueValid(value, row, col)) {
                        initialGrid[row][col] = value;
                    } else {
                        JOptionPane.showMessageDialog(SudokuGameGUI.this,
                                "Invalid move! The entered value violates Sudoku rules.",
                                "Invalid Move", JOptionPane.ERROR_MESSAGE);
                        cells[row][col].setText(""); 
                        initialGrid[row][col] = 0; 
                    }
                } else {
                    initialGrid[row][col] = 0;
                    cells[row][col].setText(""); 
                }
            } catch (NumberFormatException ex) {
                initialGrid[row][col] = 0; 
                cells[row][col].setText(""); 
            }
        }
    }

    private void solveSudoku() {
        boolean solved = solve(0, 0);
        if (solved) {
            updateGrid();
        } else {
            JOptionPane.showMessageDialog(this, "No solution exists for the given puzzle!");
        }
    }

    private boolean solve(int row, int col) {
        if (row == SIZE) {
            return true;
        }

        int nextRow = col == SIZE - 1 ? row + 1 : row;
        int nextCol = (col + 1) % SIZE;

        if (initialGrid[row][col] != 0) {
            return solve(nextRow, nextCol);
        }

        for (int num = 1; num <= SIZE; num++) {
            if (isValueValid(num, row, col)) {
                initialGrid[row][col] = num;

                if (solve(nextRow, nextCol)) {
                    return true; 
                }

             
                initialGrid[row][col] = 0;
            }
        }

        return false;     }

    private void updateGrid() {
                for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j].setText(String.valueOf(initialGrid[i][j]));
            }
        }
    }

    private int[][] copyGrid(int[][] grid) {
        int[][] copy = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            copy[i] = grid[i].clone();
        }
        return copy;
    }

    private boolean isValueValid(int value, int row, int col) {
        for (int i = 0; i < SIZE; i++) {
            if (initialGrid[row][i] == value || initialGrid[i][col] == value) {
                return false;
            }
        }
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (initialGrid[startRow + i][startCol + j] == value) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] initialGrid={{0,8,0,0,0,0,1,0,3},
		          {0,0,0,0,3,0,2,7,0},
		          {0,0,2,9,0,0,0,0,0},
		          {0,6,7,4,8,0,0,0,0},
		          {2,9,0,3,0,0,0,4,0},
		          {0,0,0,0,7,0,0,0,1},
		          {0,0,0,0,9,6,0,0,8},
		          {9,5,8,0,4,3,7,6,0},
		          {0,7,3,0,5,2,4,1,9}};

        SwingUtilities.invokeLater(() -> new SudokuGameGUI(initialGrid));
    }
}

package sudoku.solver;

import sudoku.model.SudokuBoard;

public class SudokuSolver {
    private final SudokuBoard board;

    public SudokuSolver(SudokuBoard board) {
        this.board = board;
    }

    public boolean solve() {
        int[][] grid = board.getBoard();

        for (int row = 0; row < SudokuBoard.SIZE; row++) {
            for (int col = 0; col < SudokuBoard.SIZE; col++) {
                if (grid[row][col] == 0) { // empty cell
                    for (int num = 1; num <= 9; num++) {
                        if (board.isSafe(row, col, num)) {
                            board.set(row, col, num);

                            if (solve()) return true;

                            board.set(row, col, 0); // backtrack
                        }
                    }
                    return false; // no valid number found
                }
            }
        }
        return true; // solved
    }
}

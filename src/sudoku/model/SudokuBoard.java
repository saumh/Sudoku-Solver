package sudoku.model;

public class SudokuBoard {
    private final int[][] board;
    public static final int SIZE = 9;

    public SudokuBoard(int[][] board) {
        this.board = board;
    }

    public int[][] getBoard() {
        return board;
    }

    public int get(int row, int col) {
        return board[row][col];
    }

    public void set(int row, int col, int value) {
        board[row][col] = value;
    }

    public boolean isSafe(int row, int col, int num) {
        return !usedInRow(row, num) &&
               !usedInCol(col, num) &&
               !usedInBox(row - row % 3, col - col % 3, num);
    }

    private boolean usedInRow(int row, int num) {
        for (int col = 0; col < SIZE; col++) {
            if (board[row][col] == num) return true;
        }
        return false;
    }

    private boolean usedInCol(int col, int num) {
        for (int row = 0; row < SIZE; row++) {
            if (board[row][col] == num) return true;
        }
        return false;
    }

    private boolean usedInBox(int boxRow, int boxCol, int num) {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r + boxRow][c + boxCol] == num) return true;
            }
        }
        return false;
    }
}

package sudoku.io;

import sudoku.model.SudokuBoard;

public class PuzzlePrinter {
    public static void print(SudokuBoard board) {
        int[][] grid = board.getBoard();
        for (int row = 0; row < SudokuBoard.SIZE; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("------+-------+------");
            }
            for (int col = 0; col < SudokuBoard.SIZE; col++) {
                if (col % 3 == 0 && col != 0) System.out.print("| ");
                int val = grid[row][col];
                System.out.print(val == 0 ? ". " : val + " ");
            }
            System.out.println();
        }
    }
}

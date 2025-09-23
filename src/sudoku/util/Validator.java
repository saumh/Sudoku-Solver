package sudoku.util;

import sudoku.model.SudokuBoard;

import java.util.HashSet;

public class Validator {
    public static boolean isValidSolution(SudokuBoard board) {
        int[][] grid = board.getBoard();

        // check rows and cols
        for (int i = 0; i < SudokuBoard.SIZE; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            HashSet<Integer> colSet = new HashSet<>();

            for (int j = 0; j < SudokuBoard.SIZE; j++) {
                rowSet.add(grid[i][j]);
                colSet.add(grid[j][i]);
            }
            if (rowSet.size() != 9 || colSet.size() != 9) return false;
        }

        // check 3x3 boxes
        for (int row = 0; row < SudokuBoard.SIZE; row += 3) {
            for (int col = 0; col < SudokuBoard.SIZE; col += 3) {
                HashSet<Integer> boxSet = new HashSet<>();
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        boxSet.add(grid[row + r][col + c]);
                    }
                }
                if (boxSet.size() != 9) return false;
            }
        }
        return true;
    }
}

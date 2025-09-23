package sudoku;

import sudoku.model.SudokuBoard;
import sudoku.solver.SudokuSolver;
import sudoku.io.PuzzleLoader;
import sudoku.io.PuzzlePrinter;

public class Main {
    public static void main(String[] args) {
        // Example: Load a puzzle (hardcoded or from file)
        int[][] puzzle = PuzzleLoader.fromHardcoded();

        SudokuBoard board = new SudokuBoard(puzzle);
        SudokuSolver solver = new SudokuSolver(board);

        if (solver.solve()) {
            System.out.println("Solved Sudoku:");
            PuzzlePrinter.print(board);
        } else {
            System.out.println("No solution exists.");
        }
    }
}

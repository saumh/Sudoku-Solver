package sudoku;

import sudoku.model.SudokuBoard;
import sudoku.solver.SudokuSolver;
import sudoku.io.PuzzlePrinter;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] puzzle = new int[9][9];

        System.out.println("Enter your Sudoku puzzle row by row.");
        System.out.println("Use 0 for empty cells.");
        for (int row = 0; row < 9; row++) {
            System.out.print("Row " + (row + 1) + " (9 numbers separated by space): ");
            for (int col = 0; col < 9; col++) {
                puzzle[row][col] = scanner.nextInt();
            }
        }

        SudokuBoard board = new SudokuBoard(puzzle);
        SudokuSolver solver = new SudokuSolver(board);

        System.out.println("\nInput Puzzle:");
        PuzzlePrinter.print(board);

        if (solver.solve()) {
            System.out.println("\nSolved Puzzle:");
            PuzzlePrinter.print(board);
        } else {
            System.out.println("No solution exists for the given puzzle.");
        }
        scanner.close();
    }
}

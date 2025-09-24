package tests;

import sudoku.model.SudokuBoard;
import sudoku.solver.SudokuSolver;
import sudoku.util.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuSolverTest {

    @Test
    void testSolve_ValidPuzzle() {
        int[][] puzzle = {
            {5,3,0, 0,7,0, 0,0,0},
            {6,0,0, 1,9,5, 0,0,0},
            {0,9,8, 0,0,0, 0,6,0},
            {8,0,0, 0,6,0, 0,0,3},
            {4,0,0, 8,0,3, 0,0,1},
            {7,0,0, 0,2,0, 0,0,6},
            {0,6,0, 0,0,0, 2,8,0},
            {0,0,0, 4,1,9, 0,0,5},
            {0,0,0, 0,8,0, 0,7,9}
        };

        SudokuBoard board = new SudokuBoard(puzzle);
        SudokuSolver solver = new SudokuSolver(board);

        assertTrue(solver.solve(), "Solver should complete the puzzle");
        assertTrue(Validator.isValidSolution(board), "Solution should be valid");
    }

    @Test
    void testSolve_UnsolvablePuzzle() {
        int[][] puzzle = {
            {1,1,1, 1,1,1, 1,1,1}, // clearly invalid
            {0,0,0, 0,0,0, 0,0,0},
            {0,0,0, 0,0,0, 0,0,0},
            {0,0,0, 0,0,0, 0,0,0},
            {0,0,0, 0,0,0, 0,0,0},
            {0,0,0, 0,0,0, 0,0,0},
            {0,0,0, 0,0,0, 0,0,0},
            {0,0,0, 0,0,0, 0,0,0},
            {0,0,0, 0,0,0, 0,0,0}
        };

        SudokuBoard board = new SudokuBoard(puzzle);
        SudokuSolver solver = new SudokuSolver(board);

        assertFalse(solver.solve(), "Solver should not solve invalid puzzle");
    }
}

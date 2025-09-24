package tests;

import sudoku.model.SudokuBoard;
import sudoku.util.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {

    @Test
    void testValidSolution() {
        int[][] solvedPuzzle = {
            {5,3,4, 6,7,8, 9,1,2},
            {6,7,2, 1,9,5, 3,4,8},
            {1,9,8, 3,4,2, 5,6,7},
            {8,5,9, 7,6,1, 4,2,3},
            {4,2,6, 8,5,3, 7,9,1},
            {7,1,3, 9,2,4, 8,5,6},
            {9,6,1, 5,3,7, 2,8,4},
            {2,8,7, 4,1,9, 6,3,5},
            {3,4,5, 2,8,6, 1,7,9}
        };

        SudokuBoard board = new SudokuBoard(solvedPuzzle);
        assertTrue(Validator.isValidSolution(board), "Should detect valid solution");
    }

    @Test
    void testInvalidSolution() {
        int[][] invalidPuzzle = {
            {5,5,4, 6,7,8, 9,1,2}, // duplicate 5 in row
            {6,7,2, 1,9,5, 3,4,8},
            {1,9,8, 3,4,2, 5,6,7},
            {8,5,9, 7,6,1, 4,2,3},
            {4,2,6, 8,5,3, 7,9,1},
            {7,1,3, 9,2,4, 8,5,6},
            {9,6,1, 5,3,7, 2,8,4},
            {2,8,7, 4,1,9, 6,3,5},
            {3,4,5, 2,8,6, 1,7,9}
        };

        SudokuBoard board = new SudokuBoard(invalidPuzzle);
        assertFalse(Validator.isValidSolution(board), "Should detect invalid solution");
    }
}

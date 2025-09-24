package tests;

import sudoku.model.SudokuBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuBoardTest {

    @Test
    void testIsSafe_ValidPlacement() {
        int[][] puzzle = new int[9][9];
        SudokuBoard board = new SudokuBoard(puzzle);

        // Place 5 at (0,0) and test if 5 is safe in another row/col
        board.set(0, 0, 5);
        assertFalse(board.isSafe(0, 1, 5)); // same row
        assertFalse(board.isSafe(1, 0, 5)); // same column
        assertFalse(board.isSafe(1, 1, 5)); // same 3x3 box
        assertTrue(board.isSafe(4, 4, 5));  // different row/col/box
    }

    @Test
    void testSetAndGet() {
        int[][] puzzle = new int[9][9];
        SudokuBoard board = new SudokuBoard(puzzle);

        board.set(2, 3, 7);
        assertEquals(7, board.get(2, 3));
    }
}

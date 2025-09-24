# Sudoku solver algorithm
This project uses a backtracking algorithm to solve Sudoku puzzles.
Backtracking is a type of depth-first search that tries possible solutions step-by-step and “backtracks” when a choice leads to a dead end.

## How it works
1. Find the next empty cell
    - Start scanning the 9×9 grid from top left
    - Empty cells are marked with `0`
2. Try numbers 1 through 9
    - For each candidate number:
        - Check if placing it is safe (not already in the same row, column, or 3×3 box)
3. Place the number and recurse
    - If safe, temporarily place the number
    - Move on to solve the rest of the board
4. Backtrack if stuck
    - If no number works in the current cell, reset it to empty (`0`) and return to the previous step
5. Finish when all cells are filled
    - If the algorithm reaches the end of the board without conflicts, the puzzle is solved

## Pseudocode

```
function solve(board):
    for row in 0..8:
        for col in 0..8:
            if board[row][col] == 0:             # empty cell
                for num in 1..9:
                    if isSafe(board, row, col, num):
                        board[row][col] = num    # place candidate
                        if solve(board):         # recurse
                            return true
                        board[row][col] = 0      # backtrack
                return false                     # no valid number
    return true                                  # solved

```

## Complexity
### Time Complexity (worst case)
Up to `O(9^(N))`, where `N` is the number of empty cells.

This is exponential in theory, but most puzzles are solved much faster due to pruning (the safety checks)

### Space Complexity
`O(N)` for the recursion stack (maximum depth = number of empty cells)

The board itself is fixed size (9×9)
# Design

## File structure

```
sudoku-solver/
├── src/
│   ├── model/
│   │   └── SudokuBoard.java       // board representation
│   ├── solver/
│   │   └── SudokuSolver.java      // backtracking solver logic
│   ├── io/
│   │   ├── PuzzleLoader.java      // read puzzles from file/JSON
│   │   └── PuzzlePrinter.java     // pretty-print to console/GUI
│   ├── util/
│   │   └── Validator.java         // check validity of complete board
│   └── Main.java                  // entry point
├── tests/
│   ├── SudokuSolverTest.java      // unit tests for solver
│   ├── SudokuBoardTest.java       // unit tests for board rules
│   └── ValidatorTest.java         // validation tests
└── README.md
```


## Classes/Contents

`model/SudokuBoard.java`
- Encapsulates the 9×9 grid and board operations.
- `get(int row, int col)` and `set(int row, int col, int value)`
- `isSafe(row, col, num`) → checks row/col/box
- `isComplete()` → checks if board is solved

`solver/SudokuSolver.java`
- Only contains solver strategy.
- Constructor takes a `SudokuBoard`
- `solve()` → backtracking
- Could later allow multiple strategies (BacktrackingSolver, HeuristicSolver)

`io/PuzzleLoader.java`
- Handles loading puzzles from different sources.
   - `fromFile(String path)`
   - `fromString(String puzzle)`
   - `fromJSON(File json)`

`io/PuzzlePrinter.java`
- Prints puzzles in a neat format.
```
+-------+-------+-------+
| 5 3 . | . 7 . | . . . |
| 6 . . | 1 9 5 | . . . |
| . 9 8 | . . . | . 6 . |
+-------+-------+-------+
```
`util/Validator.java`
- For finished boards
- `boolean isValidSolution(SudokuBoard board)`
- Check rows, columns, and boxes contain 1–9 exactly once.
- Good for JUnit testing.

`test/…`
- JUnit 5 tests.
- Board Tests: verify `isSafe()` works.
- Solver Tests: give it a solvable puzzle and check result.
- Validator Tests: feed it valid and invalid boards.

## Possible Extensions 
- Difficulty Estimator: measure how many backtracks were needed → classify puzzle as Easy/Medium/Hard.
- GUI (JavaFX): draw grid, let user input numbers, click "Solve".
- Multiple Solver Strategies: implement both naive backtracking and constraint propagation.
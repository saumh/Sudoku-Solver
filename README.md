# Sudoku-Solver
A Java implementation of a Sudoku solver using backtracking recursion.
Includes a modular architecture with separate components for the board, solver, input/output utilities, and validation.

## Features
- Solve standard 9×9 Sudoku puzzles using backtracking
- User input row by row of board
- Board validation (ensures solution correctness)
- Pretty-printed console output (with row/column separators)
- Modular design (model, solver, io, util packages)
- Easily extendable (adding file-based puzzles, GUI, or new solving strategies)
- JUnit test support (for solver and validation)

## Usage
### 1. Clone project

Use 
```
git clone https://github.com/saumh/Sudoku-Solver.git
```

### 2. Compile project

From the project root:
```
javac src/**/*.java
```

### 3. Run the solver

```
java -cp src sudoku.Main
```

### 4. Enter your puzzle

You’ll be prompted to enter the Sudoku grid row by row
- use 0 for empty cells
- each row must have 9 numbers separated by spaces

Example input:
```
Row 1: 5 3 0 0 7 0 0 0 0
Row 2: 6 0 0 1 9 5 0 0 0
Row 3: 0 9 8 0 0 0 0 6 0
Row 4: 8 0 0 0 6 0 0 0 3
Row 5: 4 0 0 8 0 3 0 0 1
Row 6: 7 0 0 0 2 0 0 0 6
Row 7: 0 6 0 0 0 0 2 8 0
Row 8: 0 0 0 4 1 9 0 0 5
Row 9: 0 0 0 0 8 0 0 7 9
```

### 5. View outputs

The program will print the input puzzle and the solved puzzle in a formatted grid:

```
Input Puzzle:
5 3 . | . 7 . | . . .
6 . . | 1 9 5 | . . .
. 9 8 | . . . | . 6 .
------+-------+------
8 . . | . 6 . | . . 3
4 . . | 8 . 3 | . . 1
7 . . | . 2 . | . . 6
------+-------+------
. 6 . | . . . | 2 8 .
. . . | 4 1 9 | . . 5
. . . | . 8 . | . 7 9

Solved Puzzle:
5 3 4 | 6 7 8 | 9 1 2
6 7 2 | 1 9 5 | 3 4 8
1 9 8 | 3 4 2 | 5 6 7
------+-------+------
8 5 9 | 7 6 1 | 4 2 3
4 2 6 | 8 5 3 | 7 9 1
7 1 3 | 9 2 4 | 8 5 6
------+-------+------
9 6 1 | 5 3 7 | 2 8 4
2 8 7 | 4 1 9 | 6 3 5
3 4 5 | 2 8 6 | 1 7 9
```
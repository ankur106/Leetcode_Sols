class Solution {
    private boolean[][] rows = new boolean[9][9];
    private boolean[][] cols = new boolean[9][9];
    private boolean[][] boxes = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        // Initialize state from the current board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int num = c - '1'; // convert '1'-'9' to 0-8
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[boxIndex(i, j)][num] = true;
                }
            }
        }

        // Start backtracking
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int col) {
        if (row == 9) return true;
        if (col == 9) return solve(board, row + 1, 0);
        if (board[row][col] != '.') return solve(board, row, col + 1);

        for (int d = 0; d < 9; d++) {
            if (!rows[row][d] && !cols[col][d] && !boxes[boxIndex(row, col)][d]) {
                board[row][col] = (char)(d + '1');
                rows[row][d] = cols[col][d] = boxes[boxIndex(row, col)][d] = true;

                if (solve(board, row, col + 1)) return true;

                // Backtrack
                board[row][col] = '.';
                rows[row][d] = cols[col][d] = boxes[boxIndex(row, col)][d] = false;
            }
        }

        return false;
    }

    private int boxIndex(int row, int col) {
        return (row / 3) * 3 + (col / 3);  // maps (row, col) to a 0-8 box index
    }
}
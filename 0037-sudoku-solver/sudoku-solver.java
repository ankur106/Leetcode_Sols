import java.util.HashSet;

class Solution {
    private HashSet<Character>[] rows = new HashSet[9];
    private HashSet<Character>[] cols = new HashSet[9];
    private HashSet<Character>[][] boxes = new HashSet[3][3];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boxes[i][j] = new HashSet<>();
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    rows[i].add(c);
                    cols[j].add(c);
                    boxes[i / 3][j / 3].add(c);
                }
            }
        }

        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int col) {
        if (row == 9) return true;
        if (col == 9) return solve(board, row + 1, 0);
        if (board[row][col] != '.') return solve(board, row, col + 1);

        for (char num = '1'; num <= '9'; num++) {
            if (isValid(row, col, num)) {
                board[row][col] = num;
                rows[row].add(num);
                cols[col].add(num);
                boxes[row / 3][col / 3].add(num);

                if (solve(board, row, col + 1)) return true;

                board[row][col] = '.';
                rows[row].remove(num);
                cols[col].remove(num);
                boxes[row / 3][col / 3].remove(num);
            }
        }

        return false;
    }

    private boolean isValid(int row, int col, char num) {
        return !rows[row].contains(num) &&
               !cols[col].contains(num) &&
               !boxes[row / 3][col / 3].contains(num);
    }
}
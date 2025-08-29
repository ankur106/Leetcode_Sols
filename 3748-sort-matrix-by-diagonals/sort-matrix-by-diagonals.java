class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for (int col = 1; col < m; col++) {
            sortASC(grid, 0, col);
        }

        for (int row = 0; row < n; row++) {
            sortDSC(grid, row, 0);
        }

        return grid;
    }

    void sortASC(int[][] mat, int row, int col) {
        int n = mat.length;
        int m = mat[0].length;
        for (int i = row, j = col; i < n && j < m; i++, j++) {
            for (int k = i, l = j; k < n && l < m; k++, l++) {
                if (mat[k][l] < mat[i][j]) {
                    swap(mat, i, j, k, l);
                }
            }
        }
    }

    void sortDSC(int[][] mat, int row, int col) {
        int n = mat.length;
        int m = mat[0].length;
        for (int i = row, j = col; i < n && j < m; i++, j++) {
            for (int k = i, l = j; k < n && l < m; k++, l++) {
                if (mat[k][l] > mat[i][j]) {
                    swap(mat, i, j, k, l);
                }
            }
        }
    }

    void swap(int[][] mat, int i, int j, int k, int l) {
        int temp = mat[k][l];
        mat[k][l] = mat[i][j];
        mat[i][j] = temp;
    }
}

// 1 7 3
// 5 6 2
// 4 9 8

// 1 7 3
// 9 8 2
// 4 5 6
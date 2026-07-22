class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;   // matrix is n×n
        int left = matrix[0][0], right = matrix[n - 1][n - 1];

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (countLessOrEqual(matrix, mid) >= k) {
                right = mid;        // enough elements ≤ mid → answer is mid or smaller
            } else {
                left = mid + 1;     // too few → answer is larger
            }
        }
        return left;                // left == right == the kth smallest
    }

    // count of elements ≤ x, walked as a staircase from bottom-left in O(n)
    private int countLessOrEqual(int[][] matrix, int x) {
        int n = matrix.length;
        int count = 0;
        int row = n - 1, col = 0;   // start bottom-left
        while (row >= 0 && col < n) {
            if (matrix[row][col] <= x) {
                count += row + 1;   // this column, rows 0..row are all ≤ x
                col++;              // move right
            } else {
                row--;              // move up
            }
        }
        return count;
    }
}
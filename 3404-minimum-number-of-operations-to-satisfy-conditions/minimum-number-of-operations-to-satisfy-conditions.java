class Solution {
    public int minimumOperations(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        int[][] freq = new int[m][10];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                freq[j][grid[i][j]]++;
            }
        }

        Integer[][] dp = new Integer[m][11]; // prevDigit in 0..9, or 10 for -1

        return dfs(0, 10, freq, n, m, dp);
    }

    private int dfs(int col, int prevDigit, int[][] freq, int n, int m, Integer[][] dp) {
        if (col == m) return 0;
        if (dp[col][prevDigit] != null) return dp[col][prevDigit];

        int minCost = Integer.MAX_VALUE;

        for (int d = 0; d < 10; d++) {
            if (d == prevDigit) continue;

            int cost = n - freq[col][d];
            minCost = Math.min(minCost, cost + dfs(col + 1, d, freq, n, m, dp));
        }

        dp[col][prevDigit] = minCost;
        return minCost;
    }
}
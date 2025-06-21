public class Solution {
    private int[][] grid;
    private int n;
    private int[][][] memo;

    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.memo = new int[n][n][n];
        for (int[][] layer : memo)
            for (int[] row : layer)
                Arrays.fill(row, Integer.MIN_VALUE);
        
        int result = Math.max(0, dfs(0, 0, 0)); 
        return result;
    }

    private int dfs(int r1, int c1, int r2) {
        int c2 = r1 + c1 - r2; 
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n ||
            grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return Integer.MIN_VALUE;
        
        if (r1 == n - 1 && c1 == n - 1)
            return grid[r1][c1];
        
        if (memo[r1][c1][r2] != Integer.MIN_VALUE)
            return memo[r1][c1][r2];

        int result = grid[r1][c1];
        if (r1 != r2 || c1 != c2)
            result += grid[r2][c2]; 

        int maxCherries = Math.max(
            Math.max(dfs(r1 + 1, c1, r2 + 1), dfs(r1, c1 + 1, r2)),
            Math.max(dfs(r1 + 1, c1, r2), dfs(r1, c1 + 1, r2 + 1))
        );

        result += maxCherries;

        memo[r1][c1][r2] = result;
        return result;
    }
}
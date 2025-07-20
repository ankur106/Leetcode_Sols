import java.util.Arrays;

class Solution {
    private int n, m;
    private int[][] dungeon;
    private int[][] memo;

    public int calculateMinimumHP(int[][] dungeon) {
        this.dungeon = dungeon;
        this.n = dungeon.length;
        this.m = dungeon[0].length;

        memo = new int[n][m];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (i >= n || j >= m) {
            return Integer.MAX_VALUE;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (i == n - 1 && j == m - 1) {
            memo[i][j] = Math.max(1, 1 - dungeon[i][j]);
            return memo[i][j];
        }

        int needRight = dfs(i, j + 1);
        int needDown  = dfs(i + 1, j);

        int minExitNeed = Math.min(needRight, needDown);

        memo[i][j] = Math.max(1, minExitNeed - dungeon[i][j]);
        return memo[i][j];
    }
}
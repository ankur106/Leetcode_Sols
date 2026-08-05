class Solution {
    private int[][] memo;
    private boolean[][] seen;

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        memo = new int[n][n];
        seen = new boolean[n][n];
        return diff(piles, 0, n - 1) > 0;
    }

    private int diff(int[] piles, int i, int j) {
        if (i > j) return 0;
        if (seen[i][j]) return memo[i][j];
        int best = Math.max(piles[i] - diff(piles, i + 1, j),
                            piles[j] - diff(piles, i, j - 1));
        seen[i][j] = true;
        memo[i][j] = best;
        return best;
    }
}
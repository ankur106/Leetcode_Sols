class Solution {
    int[] p; int n; Integer[][] memo;

    public int stoneGameII(int[] piles) {
        p = piles; n = p.length;
        memo = new Integer[n][n + 1];
        int total = 0; for (int x : p) total += x;
        return (total + diff(0, 1)) / 2;      // convert margin -> stones
    }

    int diff(int i, int M) {
        if (i >= n) return 0;
        int m = Math.min(M, n);               // cap for memo index
        if (memo[i][m] != null) return memo[i][m];

        int best = Integer.MIN_VALUE, take = 0;
        for (int k = 1; k <= 2 * M && i + k <= n; k++) {
            take += p[i + k - 1];
            best = Math.max(best, take - diff(i + k, Math.max(k, M)));
        }
        return memo[i][m] = best;
    }
}
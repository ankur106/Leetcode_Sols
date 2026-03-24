class Solution {
    int[] prefix;
    Integer[] memo;
    int n;

    public int stoneGameVIII(int[] stones) {
        n = stones.length;
        prefix = new int[n];
        prefix[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stones[i];
        }

        memo = new Integer[n + 1];
        return dp(1);
    }

    private int dp(int i) {
        if (i == n) return 0;
        if (i == n - 1) return prefix[n - 1];
        if (memo[i] != null) return memo[i];

        memo[i] = Math.max(
            prefix[i] - dp(i + 1),
            dp(i + 1) 
        );
        return memo[i];
    }
}
class Solution {
    int[] stones;
    int n;
    Integer[] memo;

    public String stoneGameIII(int[] stoneValue) {
        stones = stoneValue;
        n = stones.length;
        memo = new Integer[n];

        int d = diff(0);
        if (d > 0) return "Alice";
        if (d < 0) return "Bob";
        return "Tie";
    }

    // best (my total − opponent total) the current mover forces from stones[i..]
    private int diff(int i) {
        if (i >= n) return 0;                          // empty game → margin 0
        if (memo[i] != null) return memo[i];

        int best = Integer.MIN_VALUE;
        int take = 0;
        for (int k = 0; k < 3 && i + k < n; k++) {
            take += stones[i + k];                     // gain from taking k+1 stones
            best = Math.max(best, take - diff(i + k + 1));   // the magic line
        }
        return memo[i] = best;
    }
}
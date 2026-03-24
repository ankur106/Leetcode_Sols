class Solution {
    int[] prefix;
    int[][] memo;

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        memo = new int[n][n];
        for (int[] row : memo) Arrays.fill(row, -1);

        // prefix sum for O(1) range sum
        prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        return dp(0, n - 1);
    }

    private int rangeSum(int i, int j) {
        return prefix[j + 1] - prefix[i];
    }

    private int dp(int i, int j) {
        if (i == j) return 0; // one stone, game over

        if (memo[i][j] != -1) return memo[i][j];

        int result = 0;

        for (int k = i; k < j; k++) {
            int leftSum  = rangeSum(i, k);
            int rightSum = rangeSum(k + 1, j);

            if (leftSum < rightSum) {
                // Bob throws right, Alice keeps left
                result = Math.max(result, leftSum + dp(i, k));
            } else if (leftSum > rightSum) {
                // Bob throws left, Alice keeps right
                result = Math.max(result, rightSum + dp(k + 1, j));
            } else {
                // Equal: Alice picks the better side
                result = Math.max(result,
                    leftSum + Math.max(dp(i, k), dp(k + 1, j)));
            }
        }

        memo[i][j] = result;
        return result;
    }
}
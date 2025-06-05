class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        
        arr[0] = 1;
        arr[n + 1] = 1;
        
        // Copy original nums to arr with padding of 1 at both ends
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        int[][] memo = new int[n + 2][n + 2];

        return solve(arr, 1, n, memo); 
    }

    private int solve(int[] nums, int i, int j, int[][] memo) {
        if (i > j) return 0;
        if (memo[i][j] != 0) return memo[i][j];

        int max = 0;

        for (int k = i; k <= j; k++) {
            int coins = nums[k] * nums[i - 1] * nums[j + 1];
            coins += solve(nums, i, k - 1, memo); 
            coins += solve(nums, k + 1, j, memo); 
            max = Math.max(max, coins);
        }

        memo[i][j] = max;
        return max;
    }
}
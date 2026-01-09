class Solution {
    Integer[][] dp;

    public int maxDotProduct(int[] nums1, int[] nums2) {
        dp = new Integer[nums1.length][nums2.length];
        return solve(nums1, nums2, 0, 0);
    }

    private int solve(int[] nums1, int[] nums2, int i, int j) {
        if (i == nums1.length || j == nums2.length)
            return Integer.MIN_VALUE;

        if (dp[i][j] != null)
            return dp[i][j];

        int take = nums1[i] * nums2[j];
        int takeMore = take + Math.max(0, solve(nums1, nums2, i + 1, j + 1));
        int skip1 = solve(nums1, nums2, i + 1, j);
        int skip2 = solve(nums1, nums2, i, j + 1);

        return dp[i][j] = Math.max(takeMore, Math.max(skip1, skip2));
    }
}
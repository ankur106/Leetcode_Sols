class Solution {
    public long maximumTripletValue(int[] nums) {

        int[] postMax = new int[nums.length];
        postMax[nums.length - 1] = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; --i) {
            postMax[i] = Math.max(postMax[i + 1], nums[i]); 
        }

        int max = nums[0];
        long ans = Long.MIN_VALUE; 
        
        for (int i = 1; i < nums.length - 1; ++i) {
            ans = Math.max(ans, (long) (max - nums[i]) * postMax[i + 1]);
            max = Math.max(max, nums[i]);
        }
        
        return ans < 0 ? 0 : ans;
    }
}
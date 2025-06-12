class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int len = nums.length;


        int diff = Math.abs(nums[len-1] - nums[0]) ;

        for(int i=1; i < len; ++i){

            diff = Math.max(diff, Math.abs(nums[i] - nums[i-1]));
        }


        return diff;
        
    }
}
class Solution {
    public int maximumTop(int[] nums, int k) {
        if(k % 2 == 1 && nums.length == 1) return -1;
        int max = -1;
        if(k > nums.length){
            for(int num : nums)
                max = Math.max(max, num);
        }
        else{
            for(int i=0; i<k-1; i++)
                max = Math.max(max, nums[i]);
            if(k < nums.length) max = Math.max(max, nums[k]);
        }
        return max;
    }
}
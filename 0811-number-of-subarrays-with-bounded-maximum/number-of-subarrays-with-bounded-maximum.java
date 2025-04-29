class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {

        int len = nums.length;
        int ans = 0;

        int rr = len -1;
        int ll = len;
        for(int i = len - 1; i >=0; i--){
            
            if(nums[i] > right) rr = i - 1;
            if(nums[i] >= left && nums[i] <= right) ll = i;

            if(rr>= ll){
                ans += rr - ll +1;
            }

            
        
        }

        return ans;
        
    }
}
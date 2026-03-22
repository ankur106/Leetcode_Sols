class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int len = nums.length;
        
        long sum  = Long.MIN_VALUE;
        Map<Integer, Long> map = new HashMap<>();
        long currSum = 0;

        for(int i = 0; i < len; ++i){
            if(map.containsKey(nums[i] - k)) sum = Math.max(sum, currSum + nums[i] - map.get(nums[i] - k));
            if(map.containsKey(nums[i] + k)) sum = Math.max(sum, currSum + nums[i] - map.get(nums[i] + k));

            if((!map.containsKey(nums[i])|| 
                map.containsKey(nums[i]) && map.get(nums[i]) > currSum)) map.put(nums[i], currSum);
            currSum += nums[i];
        }

        return sum == Long.MIN_VALUE ? 0 : sum;
    }
}
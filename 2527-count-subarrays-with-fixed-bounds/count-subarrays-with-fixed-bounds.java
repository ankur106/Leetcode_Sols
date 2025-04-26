class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        
        int len = nums.length;
        int[] nextPossibleEnd = new int[len];

        int possible = -1;
        for(int i = len -1 ; i >= 0; --i){
            
            if(possible == -1 && nums[i] >= minK && nums[i] <= maxK) possible = i;
            if(nums[i] < minK || nums[i]  > maxK) possible  = -1;
            nextPossibleEnd[i] = possible;
        }

        int[] nextMinK = new int[len];
        int[] nextMaxK = new int[len];

        int nextMin = len;
        int nextMax = len;

        for(int i = len -1 ; i >= 0; --i){
            if(nums[i] == minK)nextMin = i;
            if(nums[i] == maxK)nextMax = i;

            nextMinK[i] = nextMin;
            nextMaxK[i] = nextMax;
        }

        long ans = 0;

        for(int i =0 ; i < len; ++i){
            if(nextPossibleEnd[i] == -1) continue;

            int min  = Math.max(nextMinK[i], nextMaxK[i]);
            int max = nextPossibleEnd[i];

            if(max < min) continue;

            ans += (max - min + 1);
        }

        return ans;
        
    }
}
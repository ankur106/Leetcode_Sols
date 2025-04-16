class Solution {
    public long countGood(int[] nums, int k) {

        long ans = 0;
        int len = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();

        int pairs = 0;

        int i=0;

        for(int j=0; j < len; ++j){
            freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            pairs += freq.get(nums[j]) - 1;
            
            while(pairs >= k){
                ans += (len - j) ;

                freq.put(nums[i], freq.get(nums[i]) - 1);
                pairs -= freq.get(nums[i]);

                if(freq.get(nums[i]) == 0) freq.remove(nums[i]);
                
                i++;    
            }

            
        }
        return ans;
    }
}
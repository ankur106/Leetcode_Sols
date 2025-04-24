class Solution {

    public int countCompleteSubarrays(int[] nums) {

        Set<Integer> st = new HashSet<>();

        for(int i : nums){
            st.add(i);
        }

        int distinct = st.size();

        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int left = 0;
        boolean wasGreater = false;

        for(int right= 0 ; right < nums.length; ++right){
            
            map.put(nums[right], map.getOrDefault(nums[right],0) +1);

            while(map.size() >=  distinct && left < nums.length){
                map.put(nums[left], map.get(nums[left])-1);
                if(map.get(nums[left])==0) map.remove(nums[left]);
                left++;

                wasGreater = true;
            }

            if(wasGreater && map.size() == distinct -1){
                ans += left;
            } 

        }

        return ans;
        
    }
}
class Solution {
    public int minimumOperations(int[] nums) {

        int maxLastIndex = 0;


        Map<Integer, Integer> mp = new HashMap<>();


        for(int i=0; i < nums.length; ++i){
            if(mp.containsKey(nums[i])){
                maxLastIndex = Math.max(maxLastIndex, mp.get(nums[i]));
            }

            mp.put(nums[i], i+1);
        }

        

        if(maxLastIndex ==0) return 0;
        
        return (int)(Math.ceil((double)maxLastIndex/3)) ;
        
    }
}
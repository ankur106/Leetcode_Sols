class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        
        TreeMap<Integer, Integer> mp = new TreeMap<>();


        for(int i = 0; i < nums.length; ++i){
            
            int next = nums[i] + valueDiff;
            int prev = nums[i] - valueDiff;

            Integer floor = mp.floorKey(next);
            Integer ceiling = mp.ceilingKey(prev);

            if(floor != null && Math.abs(nums[i] - floor) <= valueDiff && i - mp.get(floor) <= indexDiff) return true;
           
            if(ceiling != null && Math.abs(nums[i] - ceiling) <= valueDiff && i - mp.get(ceiling) <= indexDiff) return true;

            mp.put(nums[i], i);


        }

        return false;
        
    }
}
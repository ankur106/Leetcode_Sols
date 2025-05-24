class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {

        List<Integer> li = new ArrayList<>();

        int left =0, right  = nums.length -1;

        for(int num : nums){
            if(num < target)left++;
            else if(num > target)right--;
        }

        for(int i= left; i <= right; ++i){
            li.add(i);
        }


        return li;
        
    }
}
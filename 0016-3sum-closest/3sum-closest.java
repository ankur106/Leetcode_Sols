class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);

        int diff = Integer.MAX_VALUE;

        int curr = Integer.MAX_VALUE;
        for(int i = 0;  i < nums.length; ++i){
            int j = i+1, k = nums.length - 1;


            while(k>i && j < nums.length && j < k){
                int currSum = nums[i] + nums[j] + nums[k];
                
                if(Math.abs(currSum - target) < diff){
                    System.out.println(nums[i] + " " + nums[j] + " " + nums[k]);
                    diff = Math.abs(currSum - target);
                    curr = currSum;
                }

                if(currSum < target){
                    j++;
                }else {
                    k--;
                }
            }
        }

        return curr;
        
    }
}
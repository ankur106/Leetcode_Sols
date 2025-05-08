class Solution {
    public int sumOfBeauties(int[] nums) {

        int len  = nums.length;

        int[] prevMax = new int[len];
        int[] nextSmall = new int[len];

        prevMax[0] = nums[0];
        for(int i=1;  i < len; ++i){
            prevMax[i] = Math.max(prevMax[i-1], nums[i]);
        }

        nextSmall[len -1] = nums[len-1];
        for(int i= len -2;  i >= 0; --i){
            nextSmall[i] = Math.min(nextSmall[i+1], nums[i]);
        }

        int score = 0;
        for(int i=1;  i < len - 1; ++i){
            if(nums[i] > prevMax[i-1] && nums[i]  < nextSmall[i+1]) score += 2;
            else if(nums[i] > nums[i -1] && nums[i] < nums[i+1]) score++;


        }

        return score;
    }
}
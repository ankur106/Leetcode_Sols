class Solution {
    public int splitArray(int[] nums, int k) {

        int high = 0, low = 0;
        
        //maximum largest sum is sum of all num in nums
        for(int num : nums){
            high += num;
            low = Math.max(low, num);
        }

        while(low < high){
            int mid = low + (high - low)/2;

            if(subarrayWithSum(nums, mid) <= k){
                high = mid;
            }else{
                low = mid + 1;
            }
        }

        return low;
    }

    private int subarrayWithSum(int[] nums, int sum){
        int k = 0;
        int currSum = 0;
        for(int num : nums){
            currSum += num;

            if(currSum > sum){
                currSum = num;
                k++;
            }
        }
        if(currSum > 0)k++;
        return k;
    }
}
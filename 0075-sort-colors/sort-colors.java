class Solution {
    public void sortColors(int[] nums) {
        
        int low=0,mid=0, high = nums.length -1;
        
        while(mid <= high){
            if(nums[mid]==2){
                nums[mid] = nums[high];
                nums[high]= 2;
                --high;
                continue;
            }
            if(nums[mid]==1){
                ++mid;
                continue;
            }
            
            if(nums[mid]==0){
                
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                
                ++mid;
                ++low;
                continue;
            }
        }
        
    }
}
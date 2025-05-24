class Solution {
    public int[] searchRange(int[] nums, int target) {
        List<Integer> li = new ArrayList<>();

        int left =0, right  = nums.length -1;

        for(int num : nums){
            if(num < target)left++;
            else if(num > target)right--;
        }

        int[] ans  = new int[2];
        Arrays.fill(ans, -1);

        if(left <= right){
            ans[0] = left;
            ans[1] = right;

        }

        return ans;
    }
}
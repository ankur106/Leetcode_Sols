class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        findAllPermutations(nums, 0, answer);
        return answer;
    }

    public void findAllPermutations(int[] nums, int index, List<List<Integer>> answer) {
        if(index == nums.length - 1) {
            List<Integer> window = new ArrayList<>();
            for(int num: nums) {
                window.add(num);
            }
            answer.add(window);
            return;
        }
        for(int i = index; i < nums.length; i++) {

            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;

            findAllPermutations(nums, index+1, answer);

            temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
    }
}
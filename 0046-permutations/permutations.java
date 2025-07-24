class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] used) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            temp.add(nums[i]);
            backtrack(result, temp, nums, used);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}



// class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> answer = new ArrayList<>();
//         findAllPermutations(nums, 0, answer);
//         return answer;
//     }

//     public void findAllPermutations(int[] nums, int index, List<List<Integer>> answer) {
//         if(index == nums.length - 1) {
//             List<Integer> window = new ArrayList<>();
//             for(int num: nums) {
//                 window.add(num);
//             }
//             answer.add(window);
//             return;
//         }
//         for(int i = index; i < nums.length; i++) {

//             int temp = nums[index];
//             nums[index] = nums[i];
//             nums[i] = temp;

//             findAllPermutations(nums, index+1, answer);

//             temp = nums[index];
//             nums[index] = nums[i];
//             nums[i] = temp;
//         }
//     }
// }
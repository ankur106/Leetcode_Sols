import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    private void helper(int ind, int[] nums, List<Integer> curr, List<List<Integer>> ans) {
        if (ind == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[ind]);
        helper(ind + 1, nums, curr, ans);
        curr.remove(curr.size() - 1);

        int next = ind + 1;
        while (next < nums.length && nums[next] == nums[ind]) {
            next++;
        }
        helper(next, nums, curr, ans);
    }
}
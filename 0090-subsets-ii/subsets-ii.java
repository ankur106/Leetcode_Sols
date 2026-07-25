class Solution {
    int[] nums;
    List<List<Integer>> subsets;
    int len;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        this.len = nums.length;
        this.subsets = new ArrayList<>();

        findSubSets(0, new ArrayList<Integer>());
        return subsets;
    }

    private void findSubSets(int index, List<Integer> currSubSet){
        if(index == this.len){
            this.subsets.add(new ArrayList<>(currSubSet));
            return;
        }

        currSubSet.add(this.nums[index]);
        findSubSets(index + 1, currSubSet);
        currSubSet.remove(currSubSet.size() - 1);

        int currEle = this.nums[index];
        while(index != this.len && this.nums[index] == currEle){
            index++;
        }
        findSubSets(index, currSubSet);

    }
}
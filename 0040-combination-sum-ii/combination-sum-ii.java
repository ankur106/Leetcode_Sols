class Solution {
    public List<List<Integer>> combinationSum2(int[] cand, int target) {
        Arrays.sort(cand); 
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, cand, target, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int i, int[] cand, int target, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (i >= cand.length || target < 0) return;

        path.add(cand[i]);
        dfs(i + 1, cand, target - cand[i], path, res);
        path.remove(path.size() - 1);

        int next = i + 1;
        while (next < cand.length && cand[next] == cand[i]) next++;

        dfs(next, cand, target, path, res);
    }
}
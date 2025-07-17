class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int current, int n, int k, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        if (current > n) return;
        
        path.add(current);
        backtrack(current + 1, n, k, path, result);
        path.remove(path.size() - 1);

        backtrack(current + 1, n, k, path, result);
    }
}
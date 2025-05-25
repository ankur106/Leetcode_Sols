class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> ans = new ArrayList<>();

        solve(1, new ArrayList<Integer>(), ans, k, n);

        return ans;
        
    }

    private void solve(int add, List<Integer> curr, List<List<Integer>> ans, int k, int n){
        
        if(k==0 && n==0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(k < 0 || n < 0 || add > 9) return;

        curr.add(add);
        
        solve(add + 1, curr, ans, k-1, n - add);

        curr.remove(curr.size() -1);

        solve(add + 1, curr, ans, k , n);

    }
}
class Solution {
    int ans = 0;
    public int minIncrements(int n, int[] cost) {
        solve(cost, n, 0);
        return ans;
    }


    private int solve(int[] cost, int n, int index){
        if(index >= n) return 0;

        int left = solve(cost, n, index*2 +1);
        int right = solve(cost, n, index*2 +2);

        int diff = Math.abs(left - right);
        ans += diff;

        return Math.max(left, right) + cost[index];
    }
}
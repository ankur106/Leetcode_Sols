class Solution {
    public int maximumProduct(int[] nums, int k) {
        int MOD = 1000000007;

        Queue<Integer> pq = new PriorityQueue<>();

        for(int i : nums){
            pq.offer(i);
        }

        for(int i = 0; i < k; ++i){
            pq.offer(pq.poll() + 1);
        }

        int ans = 1;

        while (!pq.isEmpty()){
            ans = (int)(((long) ans * pq.poll()) % MOD);
        }

        return ans;
    }
}
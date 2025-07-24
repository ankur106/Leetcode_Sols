class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int ans[] = new int[nums.length - k +1];

        Deque<Integer> que = new ArrayDeque<>();

        for(int i=0; i < k; ++i){
            while(!que.isEmpty() &&  nums[que.peekLast()]<= nums[i]) que.pollLast();
            que.offerLast(i);
        }

        ans[0] = nums[que.peekFirst()];


        for(int i = k ;  i < nums.length; ++i){
            if (que.peekFirst() == i - k) {
                que.pollFirst();
            }

            while(!que.isEmpty() &&  nums[que.peekLast()]<= nums[i]) que.pollLast();
            que.offerLast(i);
            ans[i-k+1] = nums[que.peekFirst()];

        }

        return ans;
        
    }
}
class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] score = new int[n];
        score[0] = nums[0];
        Deque<Integer> dq = new LinkedList<>();
        dq.offerLast(0);
        for (int i = 1; i < n; i++) {
            while (dq.peekFirst() != null && dq.peekFirst() < i - k) {
                dq.pollFirst();
            }
            score[i] = score[dq.peek()] + nums[i];
            while (dq.peekLast() != null && score[i] >= score[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        return score[n - 1];
    }
}
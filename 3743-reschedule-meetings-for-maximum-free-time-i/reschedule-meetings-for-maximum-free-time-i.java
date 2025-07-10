class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;

        Queue<Integer> que = new LinkedList<>();
        int max = 0;
        que.offer(startTime[0]);
        max = startTime[0];
        int ans = startTime[0];

        for(int i=0; i<n-1; ++i){
            int currGap = startTime[i+1] - endTime[i];
            if(que.size()== k + 1){
                max -= que.poll();
            }
            max += currGap;
            que.offer(currGap);
            ans = Math.max(max, ans);
        }
        if(que.size()== k + 1){
            max -= que.poll();
        }
        int currGap = eventTime - endTime[n-1];
        max += currGap;
        que.offer(currGap);
        ans = Math.max(max, ans);

        return ans;
    }
}
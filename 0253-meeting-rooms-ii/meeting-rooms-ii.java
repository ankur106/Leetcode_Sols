class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        int len = intervals.length;
        int[] startTime = new int[len];
        int[] endTime = new int[len];

        for(int i = 0; i< len; ++i){
            startTime[i] = intervals[i][0];
            endTime[i] = intervals[i][1]; 
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int i=0; 
        int j = 0;

        int count =0;
        int ans = 0;

        while( i < len && j < len) {
            if(startTime[i] < endTime[j]){
                count++;
                i++;
            }else if (startTime[i] == endTime[j]){
                i++;
                j++;

            }else {
                j++;
                count--;
            }
            ans = Math.max(ans, count);
        }

        return ans;
    }
}

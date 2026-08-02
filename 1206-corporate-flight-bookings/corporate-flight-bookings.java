class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];

        for(int[] curr: bookings){
            int first = curr[0], last = curr[1], booked = curr[2];
            ans[first - 1] += booked;
            if(last != n) ans[last] -= booked;
        }

        int curr = 0;
        for(int i = 0; i < n; ++i){
            curr += ans[i];
            ans[i] = curr;
        }
        return ans;
    }
}
class Solution {
    public long getDescentPeriods(int[] prices) {
        long count = 0;
        int last  = Integer.MAX_VALUE;
        int lastInd = 0;
        int len = prices.length;

        for(int curr = 0; curr < len; ++curr){
            if(prices[curr] != last -1){
                lastInd = curr;
            }

            count += 1 + (curr - lastInd);
            last = prices[curr];
        }

        return count;
    }
}
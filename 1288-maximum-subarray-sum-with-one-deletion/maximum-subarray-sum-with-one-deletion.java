class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        
        if (n == 0) {
            return 0; 
        }
 
        int max_ending_here_no_del = arr[0];

        int max_ending_here_with_del = arr[0]; 

        int overall_max_sum = arr[0];

        for (int i = 1; i < n; i++) {

            max_ending_here_with_del = Math.max(max_ending_here_no_del, max_ending_here_with_del + arr[i]);

            max_ending_here_no_del = Math.max(arr[i], max_ending_here_no_del + arr[i]);

            overall_max_sum = Math.max(overall_max_sum, max_ending_here_no_del);
            overall_max_sum = Math.max(overall_max_sum, max_ending_here_with_del);
        }

        return overall_max_sum;
    }
}
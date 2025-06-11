import java.util.*;

// class Solution {
//     public int maxEnvelopes(int[][] envelopes) {
//         int n = envelopes.length;

//         Arrays.sort(envelopes, (a, b) -> {
//             if (a[0] == b[0]) return b[1] - a[1];
//             return a[0] - b[0];
//         });

//         int[][] memo = new int[n + 1][n + 1]; 

//         for (int currIndex = n - 1; currIndex >= 0; currIndex--) {
//             for (int prevIndex = currIndex - 1; prevIndex >= -1; prevIndex--) {
//                 int skip = memo[currIndex + 1][prevIndex + 1];

//                 int take = 0;
//                 if (prevIndex == -1 || 
//                     (envelopes[currIndex][0] > envelopes[prevIndex][0] &&
//                      envelopes[currIndex][1] > envelopes[prevIndex][1])) {
//                     take = 1 + memo[currIndex + 1][currIndex + 1];
//                 }

//                 memo[currIndex][prevIndex + 1] = Math.max(skip, take);
//             }
//         }

//         return memo[0][0];
//     }
// }

// class Solution {
//     public int maxEnvelopes(int[][] envelopes) {
//         int n = envelopes.length;

//         Arrays.sort(envelopes, (a, b) -> {
//             if (a[0] == b[0]) return b[1] - a[1];
//             return a[0] - b[0];
//         });

//         Integer[][] memo = new Integer[n][n + 1];

//         return solve(envelopes, 0, -1, memo);
//     }

//     private int solve(int[][] envelopes, int currIndex, int prevIndex, Integer[][] memo) {
//         if (currIndex == envelopes.length) return 0;

//         if (memo[currIndex][prevIndex + 1] != null) return memo[currIndex][prevIndex + 1];

//         int skip = solve(envelopes, currIndex + 1, prevIndex, memo);

//         int take = 0;
//         if (prevIndex == -1 || 
//             (envelopes[currIndex][0] > envelopes[prevIndex][0] &&
//              envelopes[currIndex][1] > envelopes[prevIndex][1])) {
//             take = 1 + solve(envelopes, currIndex + 1, currIndex, memo);
//         }

//         memo[currIndex][prevIndex + 1] = Math.max(skip, take);
//         return memo[currIndex][prevIndex + 1];
//     }
// }



class Solution {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return arr2[1] - arr1[1];
                } else {
                    return arr1[0] - arr2[0];
                }
           }
        });
        int[] secondDim = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; ++i) secondDim[i] = envelopes[i][1];
        return lengthOfLIS(secondDim);
    }
}

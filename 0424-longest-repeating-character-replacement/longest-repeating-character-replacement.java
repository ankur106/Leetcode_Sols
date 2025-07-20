class Solution {
    public int characterReplacement(String a, int k) {
        int max = 0;
        char[] s  = a.toCharArray();
        int n = s.length; 
        //start with 'A' to 'Z' as choosen character
        for(int  st = 'A';st<='Z' ;st++){
            int left = 0,count = 0;
            //move right pointer one step right
            for(int right =0; right<n ;right++ ){
                //count if first char choosen is same current char
                if(s[right] != st) count++;
                //move left pointer if count of different char > k
                while( left < right && count > k ){
                    //reduce the count
                    if(s[left] != st) count--;
                    left++;
                }
                //track the max size of window
                max = Math.max(max,right-left+1);
            }
        }
    
        return max;
    }
}


// class Solution {
//     public int characterReplacement(String s, int k) {
//         int[] count = new int[26];
//         int maxCount = 0, maxLen = 0;
//         int left = 0;

//         for (int right = 0; right < s.length(); right++) {
//             int idx = s.charAt(right) - 'A';
//             count[idx]++;
//             maxCount = Math.max(maxCount, count[idx]);

//             if ((right - left + 1) - maxCount > k) {
//                 count[s.charAt(left) - 'A']--;
//                 left++;
//             }

//             maxLen = Math.max(maxLen, right - left + 1);
//         }

//         return maxLen;
//     }
// }
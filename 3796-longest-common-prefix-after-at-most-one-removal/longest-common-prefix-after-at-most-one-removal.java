class Solution {
    public int longestCommonPrefix(String s, String t) {
        int p1 = 0, p2 = 0;
        int atmost = 0;
        while (p1 < s.length() && p2 < t.length()) {
            if (s.charAt(p1) == t.charAt(p2)) {
                p1++; p2++;
            } else if (atmost > 0) {
                break;
            } else {
                p1++;
                atmost++;
            }
        }

        return p2;
    }
}


// class Solution {
//     Map<String, Integer> memo = new HashMap<>();

//     public int longestCommonPrefix(String s, String t) {
//         return dfs(s, t, 0, 0, 0);
//     }

//     private int dfs(String s, String t, int i, int j, int removed) {
//         if (i >= s.length() || j >= t.length()) return 0;

//         String key = i + "," + j + "," + removed;
//         if (memo.containsKey(key)) return memo.get(key);

//         int res = 0;

//         if (s.charAt(i) == t.charAt(j)) {
//             int take = 1 + dfs(s, t, i + 1, j + 1, removed);
//             int skip = 0;
//             if (removed == 0) {
//                 skip = dfs(s, t, i + 1, j, 1);
//             }
//             res = Math.max(take, skip);
//         } else {
//             if (removed == 0) {
//                 res = dfs(s, t, i + 1, j, 1);
//             } else {
//                 res = 0; 
//             }
//         }

//         memo.put(key, res);
//         return res;
//     }
// }
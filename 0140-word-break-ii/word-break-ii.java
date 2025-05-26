// class Solution {
//     public List<String> wordBreak(String s, List<String> wordDict) {
//         Map<Integer, List<String>> map = new HashMap<>();


//         Set<String>  st = new HashSet<>(wordDict);


//         solve(s, map, st, 0);

//         return map.get(0);
        
//     }


//     private void solve(String s,  Map<Integer, List<String>> map ,  Set<String>  st, int index){
        
//         map.put(index, new ArrayList<String>());

//         List<String> curr = map.get(index);
//         for(int i = index; i < s.length(); ++i){
//             String sub = s.substring(index, i+1 );

//             if(!st.contains(sub))   continue;
            
//             if(i + 1 == s.length()){ 
//                 curr.add(sub);
//                 break;    
//             }

//             if(!map.containsKey(i+1))solve(s, map, st, i+1);

//             for(String ss : map.get(i+1)){
//                 curr.add(sub + " " + ss);
//             }


//         }
//     }
// }



class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();
        return dfs(s, 0, wordSet, memo);
    }

    private List<String> dfs(String s, int index, Set<String> wordSet, Map<Integer, List<String>> memo) {
        if (memo.containsKey(index)) return memo.get(index);

        List<String> result = new ArrayList<>();

        if (index == s.length()) {
            result.add(""); // base case: empty string to concatenate
            return result;
        }

        for (int end = index + 1; end <= s.length(); end++) {
            String word = s.substring(index, end);

            if (!wordSet.contains(word)) continue;

            List<String> subList = dfs(s, end, wordSet, memo);
            for (String sub : subList) {
                result.add(word + (sub.isEmpty() ? "" : " " + sub));
            }
        }

        memo.put(index, result);
        return result;
    }
}
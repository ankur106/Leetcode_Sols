class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<>();
        Set<String> dict = new HashSet<>(Arrays.asList(words));
        
        for (String word : words) {
            if (word.isEmpty()) continue;
            dict.remove(word);
            if (canForm(word, dict, new Boolean[word.length()], 0)) {
                ans.add(word);
            }
            dict.add(word);
        }
        
        return ans;
    }
    
    private boolean canForm(String word, Set<String> dict, Boolean[] memo, int start) {
        if (start == word.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        
        for (int end = start + 1; end <= word.length(); end++) {
            String prefix = word.substring(start, end);
            if (dict.contains(prefix) && canForm(word, dict, memo, end)) {
                return memo[start] = true;
            }
        }
        
        return memo[start] = false;
    }
}


// class Node{
//     Node[] next;
//     boolean isEnd;

//     Node(){
//         next = new Node[26];
//     }
// }
// class Trie{
//     Node root;

//     Trie(){
//         root = new Node();
//     }

//     void insert(String s){
//         Node curr = root;

//         for(char c : s.toCharArray()){
//             if(curr.next[c - 'a'] == null){
//                 curr.next[c - 'a'] = new Node();
//             }
//             curr = curr.next[c - 'a'];
//         }

//         curr.isEnd = true;
//     }

//     int count(String s){
//         Node curr = root;
//         int count = 0;
//         for(char c : s.toCharArray()){
//             curr = curr.next[c - 'a'];
//             if(curr.isEnd){
//                 count++
//             }
//         }

//         return count;
//     }

// }



// class Solution {
//     public List<String> findAllConcatenatedWordsInADict(String[] words) {

//         Trie tr = new Trie();

//         for(String s : words){
//             tr.insert(s);
//         }

//         List<String> ans = new ArrayList<>();

//         for(String s : words){
//            if(tr.count(s) > 1) ans.add(s);
//         }

//         return ans;
        
//     }
// }
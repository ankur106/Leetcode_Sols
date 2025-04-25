import java.util.*;

class Solution {

    class TrieNode {
        TrieNode[] childNode = new TrieNode[26];
        boolean isEnd = false;
        int index = 0;
    }

    class Trie {

        TrieNode root;

        Trie(){
            root = new TrieNode();
        }

        public void insert(String s, int index){
            int len = s.length();

            TrieNode node = root;
            for(int i = len - 1; i >= 0; --i){
                if(node.childNode[s.charAt(i) - 'a'] == null)
                    node.childNode[s.charAt(i) - 'a'] = new TrieNode();

                node = node.childNode[s.charAt(i) - 'a'];
            } 

            if(node.isEnd) return; 
            node.isEnd = true;
            node.index = index;
        }

        public int findString(String query){
            int len = query.length();

            TrieNode node = root;
            // if(node.childNode[query.charAt(len-1) - 'a'] == null ) return 1;
            for(int i = len - 1; i >= 0; --i){
                if(node.childNode[query.charAt(i) - 'a'] == null) break;
                node = node.childNode[query.charAt(i) - 'a'];
            }

            return findSmallest(node);
        }

        private int findSmallest(TrieNode node){
            Queue<TrieNode> que = new LinkedList<>();

            if (node.isEnd) return node.index;

            for(TrieNode n : node.childNode){
                if(n != null) que.offer(n);
            }

            while(!que.isEmpty()){
                int size = que.size();
                int index = Integer.MAX_VALUE;

                for(int i = 0; i < size; ++i){
                    TrieNode curr = que.poll();

                    if(curr.isEnd) index = Math.min(index, curr.index);
                    for(TrieNode n : curr.childNode){
                        if(n != null) que.offer(n);
                    }
                }

                if(index != Integer.MAX_VALUE) return index;
            }

            return -1; // fallback
        }    
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Trie trie = new Trie();

        Map<String, Integer> memo = new HashMap<>();

        int index = 0;
        for(String s : wordsContainer){
            trie.insert(s, index++);
        }

        int len = wordsQuery.length;
        int[] ans = new int[len];

        index = 0;
        for(String s : wordsQuery ){
            
            if(!memo.containsKey(s)){
                memo.put(s, trie.findString(s));

            }
            ans[index] = memo.get(s);
        
            index++;
        } 

        return ans;
    }
}
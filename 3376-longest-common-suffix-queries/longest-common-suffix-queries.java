class Solution {

    class TrieNode {
        int index;
        TrieNode[] child = new TrieNode[26];
        TrieNode(int index) {
            this.index = index;
        }
    }
    
    public int[] stringIndices(String[] words, String[] query) {
        int n = words.length, k = 0;
        TrieNode root = new TrieNode(0);
        for (int i = 0; i < n; i++) {
            int m = words[i].length();
            if (m < words[root.index].length()) {
                root.index = i;
            }
            TrieNode node = root;
            for (int j = m-1; j >= 0; j--) {
                int c = words[i].charAt(j)-'a';
                if (node.child[c] == null) {
                    node.child[c] = new TrieNode(i);
                }
                node = node.child[c];
                if (m < words[node.index].length()) {
                    node.index = i;
                }
            }
        }

        int[] ans = new int[query.length];
        for (String q : query) {
            TrieNode node = root;
            for (int j = q.length()-1; j >= 0; j--) {
                int c = q.charAt(j)-'a';
                if (node.child[c] == null) {
                    break;
                }
                node = node.child[c];
            }

            ans[k++] = node.index;
        }

        return ans;
    }
}
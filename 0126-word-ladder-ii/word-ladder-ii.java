class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> pre = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        Set<String> lookup = new HashSet<>(wordList);
        if (!lookup.contains(endWord)) return ans;

        Queue<String> que = new LinkedList<>();
        que.offer(beginWord);
        if (lookup.contains(beginWord)) lookup.remove(beginWord);

        boolean found = false;

        while (!que.isEmpty() && !found) {
            int size = que.size();
            Set<String> toRemove = new HashSet<>();

            for (int i = 0; i < size; ++i) {
                String curr = que.poll();

                for (int j = 0; j < curr.length(); ++j) {
                    char[] charArray = curr.toCharArray();

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == charArray[j]) continue;
                        charArray[j] = c;
                        String converted = new String(charArray);

                        if (lookup.contains(converted)) {
                            if (!toRemove.contains(converted)) {
                                toRemove.add(converted);
                                que.offer(converted);
                            }
                            pre.putIfAbsent(converted, new ArrayList<>());
                            pre.get(converted).add(curr);
                        }
                    }
                }
            }

            if (toRemove.contains(endWord)){ found = true; break;}
            lookup.removeAll(toRemove);
        }

        if (found) {
            LinkedList<String> path = new LinkedList<>();
            path.add(endWord);
            dfs(ans, pre, path, endWord, beginWord);
        }

        return ans;
    }

    private void dfs(List<List<String>> ans, Map<String, List<String>> pre, LinkedList<String> path, String word, String beginWord) {
        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            ans.add(temp);
            return;
        }

        if (!pre.containsKey(word)) return;

        for (String prev : pre.get(word)) {
            path.addLast(prev);
            dfs(ans, pre, path, prev, beginWord);
            path.removeLast();
        }
    }
}
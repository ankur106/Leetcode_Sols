import java.util.HashMap;

class Solution {
    public int longestPalindrome(String[] words) {

        HashMap<String, Integer> map = new HashMap<>();

        // Count frequency of each word
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int ans = 0;
        boolean hasMiddle = false;

        for (String word : map.keySet()) {
            int count = map.get(word);
            if (count == 0) continue;

            String revWord = new StringBuilder(word).reverse().toString();

            if (word.charAt(0) == word.charAt(1)) {
                int pairs = count / 2;
                ans += pairs * 4;
                map.put(word, count % 2);

                if (!hasMiddle && map.get(word) > 0) {
                    ans += 2;
                    hasMiddle = true;
                    map.put(word, map.get(word) - 1);
                }

            } else if (map.containsKey(revWord)) {
                int revCount = map.get(revWord);
                int pairs = Math.min(count, revCount);
                ans += pairs * 4;
                map.put(word, count - pairs);
                map.put(revWord, revCount - pairs);
            }
        }

        return ans;
    }
}
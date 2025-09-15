import java.util.*;

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {

        String[] words = text.split(" ");

        Set<Character> broken = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) {
            broken.add(c);
        }

        int cnt = 0;
        
        for (String word : words) {
            boolean canType = true;

            for (char c : word.toCharArray()) {
                if (broken.contains(c)) {
                    canType = false;
                    break;  // stop checking this word
                }
            }

            if (canType) {
                cnt++;
            }
        }

        return cnt;
    }
}
class Solution {
    public String reorganizeString(String s) {
        var charCounts = new int[26];
        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }
        int maxCount = 0, letter = 0;
        for (int i = 0; i < charCounts.length; i++) {
            if (charCounts[i] > maxCount) {
                maxCount = charCounts[i];
                letter = i;
            }
        }
        if (maxCount > (s.length() + 1) / 2) {
            return "";
        }
        var ans = new char[s.length()];
        int index = 0;

        // Place the most frequent letter
        while (charCounts[letter] != 0) {
            ans[index] = (char) (letter + 'a');
            index += 2;
            charCounts[letter]--;
        }

        // Place rest of the letters in any order
        for (int i = 0; i < charCounts.length; i++) {
            while (charCounts[i] > 0) {
                if (index >= s.length()) {
                    index = 1;
                }
                ans[index] = (char) (i + 'a');
                index += 2;
                charCounts[i]--;
            }
        }

        return String.valueOf(ans);
    }
}



// public class Solution {
//     public String reorganizeString(String s) {
//         HashMap<Character, Integer> freqMap = new HashMap<>();
//         for (char c : s.toCharArray()) {
//             freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
//         }

//         PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
//         maxHeap.addAll(freqMap.keySet());

//         StringBuilder res = new StringBuilder();
//         while (maxHeap.size() >= 2) {
//             char char1 = maxHeap.poll();
//             char char2 = maxHeap.poll();

//             res.append(char1);
//             res.append(char2);

//             freqMap.put(char1, freqMap.get(char1) - 1);
//             freqMap.put(char2, freqMap.get(char2) - 1);

//             if (freqMap.get(char1) > 0) maxHeap.add(char1);
//             if (freqMap.get(char2) > 0) maxHeap.add(char2);
//         }

//         if(!maxHeap.isEmpty()){
//             char ch = maxHeap.poll();
//             if (freqMap.get(ch) > 1) return "";
//             res.append(ch);
//         }

//         return res.toString();
//     }
// }
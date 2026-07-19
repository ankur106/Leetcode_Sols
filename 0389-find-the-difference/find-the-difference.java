class Solution {
    public char findTheDifference(String s, String t) {
        int[] freqOfChars = new int[26];
        
        for(char c : t.toCharArray()){
            freqOfChars[c - 'a']++;
        }
        
        for(char c : s.toCharArray()){
            freqOfChars[c - 'a']--;
        }
        
        int i = 0;
        for(; i < 26; ++i){
            if(freqOfChars[i] > 0) break;
        }
        
        // Explicitly cast the int back to a char
        return (char) ('a' + i);
    }
}

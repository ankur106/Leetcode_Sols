import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        // Convert to char arrays
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        // Sort arrays in place (these methods return void)
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        
        // Convert back to strings and compare
        return new String(sChars).equals(new String(tChars));
    }
}

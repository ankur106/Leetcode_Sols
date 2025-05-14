import java.util.*;

class Solution {
    public List<String> cellsInRange(String s) {
        String[] strs = s.split(":");

        char c1 = strs[0].charAt(0);
        char c2 = strs[1].charAt(0);

        int r1 = Integer.parseInt(strs[0].substring(1));
        int r2 = Integer.parseInt(strs[1].substring(1));

        char startCol = (char) Math.min(c1, c2);
        char endCol = (char) Math.max(c1, c2);
        int startRow = Math.min(r1, r2);
        int endRow = Math.max(r1, r2);

        List<String> ans = new ArrayList<>();

        for (char col = startCol; col <= endCol; col++) {
            for (int row = startRow; row <= endRow; row++) {
                ans.add(col + Integer.toString(row));
            }
        }

        return ans;
    }
}
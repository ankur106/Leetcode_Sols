import java.util.*;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            int index1 = a.indexOf(" ");
            int index2 = b.indexOf(" ");

            boolean isDigitA = Character.isDigit(a.charAt(index1 + 1));
            boolean isDigitB = Character.isDigit(b.charAt(index2 + 1));

            if (isDigitA && isDigitB) {
                return 0; 
            } else if (isDigitA) {
                return 1; 
            } else if (isDigitB) {
                return -1;
            } else {
                String idA = a.substring(0, index1);
                String logA = a.substring(index1 + 1);
                String idB = b.substring(0, index2);
                String logB = b.substring(index2 + 1);

                int cmp = logA.compareTo(logB);
                if (cmp == 0) {
                    return idA.compareTo(idB);
                }
                return cmp;
            }
        });

        return logs;
    }
}
class Solution {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();

        if (nLen == 0) return 0;

        int[] lps = calLps(needle);
        int h = 0, n = 0;

        while (h < hLen) {
            if (haystack.charAt(h) == needle.charAt(n)) {
                h++;
                n++;
                if (n == nLen) return h - nLen;
            } else {
                if (n != 0) {
                    n = lps[n - 1];
                } else {
                    h++;
                }
            }
        }

        return -1;
    }

    private int[] calLps(String m) {
        int len = m.length();
        int[] lps = new int[len];
        int i = 0, j = 1;

        while (j < len) {
            if (m.charAt(i) == m.charAt(j)) {
                i++;
                lps[j] = i;
                j++;
            } else {
                if (i != 0) {
                    i = lps[i - 1]; 
                } else {
                    lps[j] = 0;
                    j++;
                }
            }
        }

        return lps;
    }
}
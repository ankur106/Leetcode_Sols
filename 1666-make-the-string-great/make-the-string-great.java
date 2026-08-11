class Solution {
    public String makeGood(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        char[] chars = s.toCharArray();

        // Points to the next available position in our simulated stack.
        int write = 0;

        // The read pointer examines every character once.
        for (int read = 0; read < chars.length; read++) {

            // Uppercase and lowercase versions of an English letter differ
            // by 32 in ASCII, such as 'a' and 'A'.
            boolean formsBadPair =
                    write > 0 &&
                    Math.abs(chars[write - 1] - chars[read]) == 32;

            if (formsBadPair) {
                // Pop the previous character because the pair cancels.
                write--;
            } else {
                // Push the current character onto the simulated stack.
                chars[write] = chars[read];
                write++;
            }
        }

        // Only indices [0, write) contain the final valid string.
        return new String(chars, 0, write);
    }
}
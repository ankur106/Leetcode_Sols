class Solution {
    public String processStr(String s) {

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c) && Character.isLowerCase(c)) {
                sb.append(c);
            } else if (c == '*') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else if (c == '%') {
                sb.reverse();
            } else if (c == '#') {
                sb.append(sb.toString());
            }
        }

        return sb.toString();
    }
}
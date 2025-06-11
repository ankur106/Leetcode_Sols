import java.util.*;

class Solution {
    public String applySubstitutions(List<List<String>> replacements, String text) {
        Map<String, String> rawMap = new HashMap<>();
        Map<String, String> resolved = new HashMap<>();

        for (List<String> pair : replacements) {
            rawMap.put(pair.get(0), pair.get(1));
        }

        for (String key : rawMap.keySet()) {
            resolve(key, rawMap, resolved);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); ) {
            if (text.charAt(i) == '%') {
                int end = text.indexOf('%', i + 1);
                String key = text.substring(i + 1, end);
                result.append(resolved.get(key));
                i = end + 1;
            } else {
                result.append(text.charAt(i));
                i++;
            }
        }

        return result.toString();
    }

    private String resolve(String key, Map<String, String> rawMap, Map<String, String> resolved) {
        if (resolved.containsKey(key)) return resolved.get(key);

        String val = rawMap.get(key);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < val.length(); ) {
            if (val.charAt(i) == '%') {
                int end = val.indexOf('%', i + 1);
                String innerKey = val.substring(i + 1, end);
                sb.append(resolve(innerKey, rawMap, resolved));
                i = end + 1;
            } else {
                sb.append(val.charAt(i));
                i++;
            }
        }

        resolved.put(key, sb.toString());
        return sb.toString();
    }
}
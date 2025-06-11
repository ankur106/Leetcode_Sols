class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String sortedStr = new String(charArr);

            map.putIfAbsent(sortedStr, new ArrayList<String>());
            map.get(sortedStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
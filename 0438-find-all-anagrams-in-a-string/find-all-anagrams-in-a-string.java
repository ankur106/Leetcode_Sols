class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> anagramIndex = new ArrayList<>();
        int sLen = s.length();

        int pLen = p.length();

        if(sLen < pLen) return anagramIndex;

        int[] pFreq = new int[26];
        int[] sFreq = new int[26];


        for(char c : p.toCharArray()){
            pFreq[c - 'a']++;
        }

        for(int i = 0; i < sLen; ++i){
            char curr = s.charAt(i);
            sFreq[curr - 'a']++;
            
            if(i >= pLen ){
                char prev = s.charAt(i - pLen);
                sFreq[prev - 'a']--;
            }

            if(Arrays.equals(sFreq, pFreq)) anagramIndex.add(i - (pLen -1));

        }
        return anagramIndex;
    }
}
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();


        char[] charArray = s.toCharArray();
        int[] endIndex = new int[26];


        for(int i=0; i < charArray.length; ++i){
            endIndex[charArray[i] - 'a'] = i;
        }

        int end = -1;
        int start = 0;
        for(int i=0; i < charArray.length; ++i){
            end = Math.max(end, endIndex[charArray[i] - 'a']);
            if(i == end){
                ans.add(end - start + 1); 
                start = i +1;
                end = -1;
            }

            

        }

        return ans;

    }
}
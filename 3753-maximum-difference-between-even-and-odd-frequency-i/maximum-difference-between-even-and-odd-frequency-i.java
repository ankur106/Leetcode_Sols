class Solution {
    public int maxDifference(String s) {

        int[] freq = new int[26];

        for(char c : s.toCharArray()){
            freq[c - 'a']++; 
        }


        int maxOdd = 0, minOdd = Integer.MAX_VALUE;
        int maxEven = 0, minEven = Integer.MAX_VALUE;


        for(int i : freq){
            if(i==0) continue;

            if(i % 2 == 0){
                maxEven = Math.max(maxEven, i);
                minEven = Math.min(minEven, i);
            }else{

                maxOdd = Math.max(maxOdd, i);
                minOdd = Math.min(minOdd, i);

            }
        }

        return  maxOdd - minEven;    
    }
}
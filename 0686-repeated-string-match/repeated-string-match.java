class Solution {
    public int repeatedStringMatch(String a, String b) {

        int aLen = a.length();
        int bLen = b.length();

        int repeat = (int)Math.ceil((double)bLen/aLen);

        String nString  = a.repeat(repeat);

        if(nString.contains(b)) return repeat;

        nString = a.repeat(repeat + 1);
        if(nString.contains(b)) return repeat + 1;
        


        return -1;


        
    }
}
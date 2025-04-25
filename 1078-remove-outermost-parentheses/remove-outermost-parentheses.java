class Solution {
    public String removeOuterParentheses(String s) {

        int lPtr = 0;
        int rPtr = 0;

        int lPrts = 0;
        int rPrts = 0;

        int len = s.length();
        String ans = "";
        while(lPtr < len && rPtr < len){
            
            if(s.charAt(rPtr) == '(') lPrts++;
            else rPrts++;


            if(lPrts == rPrts){
                ans += s.substring(lPtr + 1, rPtr);
                rPtr++;
                lPtr = rPtr;
                continue;
            }
            rPtr++;
        }


        return ans;
        
    }
}
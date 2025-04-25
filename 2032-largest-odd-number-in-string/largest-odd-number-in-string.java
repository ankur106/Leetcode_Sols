class Solution {
    public String largestOddNumber(String num) {
        int len = num.length();
        
        int i = len -1;

        for(; i >=0; --i){
            
            if((int)num.charAt(i) % 2 != 0) break;

        }
        if(i== -1 ) return "";
        return num.substring(0, i + 1);
    }
}
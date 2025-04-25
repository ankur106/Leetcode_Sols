class Solution {
    public int romanToInt(String s) {

        int ans = 0;

        int prev = 0;
        int len  = s.length();
        
        for(int i = len - 1; i >=0; --i){
            int val = valof(s.charAt(i));

            if(val >= prev){
                ans +=val;
            }else {
                ans -= val;
            }

            prev = val;
        }

        return ans;
        
    }

    private int valof(char c){
        int ans = 0;

        switch(c) {
            case 'I':
                ans = 1;
                break;
            
            case 'V':
                ans = 5;
                break;
            
            case 'X':
                ans = 10;
                break;

            
            case 'L':
                ans = 50;
                break;

            case 'C':
                ans = 100;
                break;

            case 'D':
                ans = 500;
                break;

            case 'M':
                ans = 1000;
                break;
            
            
        }

        return ans;
    }
}
class Solution {
    public boolean makePalindrome(String s) {
        int len = s.length();
        int low = 0, high = s.length() - 1;

        int change = 0 ;

        while(low <= high){
            if(s.charAt(low) != s.charAt(high)) change++;
            if(change > 2 ) break;
            low++;
            high--;
        }

        return change <=2;
        
    }
}
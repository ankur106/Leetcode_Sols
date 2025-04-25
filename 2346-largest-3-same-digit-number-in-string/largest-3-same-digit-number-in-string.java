class Solution {
    public String largestGoodInteger(String num) {
        int[] freq = new int[10];
        int len = num.length();
        String ans = "";

        char[] arr = num.toCharArray();
        if(len < 3) return ans;
        
        
        for(int i=0; i < 3; ++i){
            freq[arr[i] - '0']++;    
        }
        
        if(freq[arr[2] - '0'] == 3) ans = String.valueOf(arr[2]).repeat(3);
        
        for(int i=3; i < len; ++i){

            freq[arr[i] - '0']++;
            freq[arr[i-3] - '0']--;
            
            if(freq[arr[i] - '0'] == 3 && ans.compareTo(String.valueOf(arr[i]).repeat(3)) < 0){
                ans = String.valueOf(arr[i]).repeat(3);
            }
        }
        

        return ans;




    }
}
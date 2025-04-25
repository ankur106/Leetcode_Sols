class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        
        StringBuilder sb = new StringBuilder();
        String prev = countAndSay(n-1);

        int len = prev.length();

        int count = 0;
        char prevChar = prev.charAt(0);

        for(int i=0; i < len; ++i){
            if(prev.charAt(i) == prevChar){
                count++;
            }else{
                sb.append(count);
                sb.append(prevChar);
                count = 1;
                prevChar = prev.charAt(i);
            }
        }
 
            sb.append(count);
            sb.append(prevChar);


        
        return sb.toString();

    }

}
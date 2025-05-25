class Solution {
    public int longestPalindrome(String[] words) {
        int ans=0;
        int arr[][]=new int[26][26];
        for(String s:words){
            int a=s.charAt(0)-'a',b=s.charAt(1)-'a';
            if(arr[b][a]!=0){
                arr[b][a]--;
                ans+=4;
            }
            else arr[a][b]++;
        }
        for(int i=0;i<26;i++) if(arr[i][i]!=0){ans+=2; break;}
        return ans;
    }
}
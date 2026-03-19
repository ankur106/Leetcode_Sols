class Solution {
    public int score(String[] cards, char x) {
        int[] left = new int[10];
        int[] right = new int[10];
        int both = 0;
        int l = 0;
        int r = 0;
        for(String i : cards){
            if(i.charAt(0) == x && i.charAt(1) == x){
                both++;
            }
            else if(i.charAt(0) == x){
                left[i.charAt(1)-'a']++;
                l++;
            }
            else if(i.charAt(1) == x){
                right[i.charAt(0)-'a']++;
                r++;
            }
        }
        int maxL = 0;
        int maxR = 0;
        for(int i=0; i<10; i++){
            maxL = Math.max(maxL, left[i]);
            maxR = Math.max(maxR, right[i]); 
        }
        int pairA = Math.min(l / 2, l - maxL);
        int unpaired = l - 2 * pairA;
        int pairB = Math.min(r / 2, r - maxR);
        unpaired += r - 2 * pairB;
        int ans = pairA + pairB + Math.min(both, unpaired);
        if(both > unpaired){
            ans += Math.min(pairA + pairB, (both - unpaired) / 2);
        }
        return ans;
    }
}
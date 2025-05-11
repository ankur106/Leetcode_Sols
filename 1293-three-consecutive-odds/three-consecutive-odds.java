class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        
        int num = 0;
        
        for(int i : arr){
            if(i%2 != 0)num++;
            else num =0;

            System.out.println(i + " "+ num);
            if(num==3)return true;
        }
        return false;
        
    }
}
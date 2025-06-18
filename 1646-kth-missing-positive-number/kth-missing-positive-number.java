class Solution {
    public int findKthPositive(int[] arr, int k) {

        int missNum  = k;

        for(int i : arr){
            if(i <= missNum) missNum++;
        }


        return missNum;
        
    }
}
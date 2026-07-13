class Solution {
    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> ans = new ArrayList<>();

        for(int i = 1; i <= 9; ++i){
            int number = i;

            for(int j = i+1; j <= 9; ++j){
                number *= 10;
                number += j;
                if(number < low) continue;
                if(number > high) break;

                ans.add(number);
            }
        }

        Collections.sort(ans);
        return ans;
    }
}
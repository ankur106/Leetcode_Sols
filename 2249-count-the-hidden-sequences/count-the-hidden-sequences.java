class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        
        long curr = 0;
        long max = 0;
        long low = 0;
        for(int diff : differences){
            curr  += diff;
            max = Math.max(max, curr);
            low = Math.min(low, curr);
        }

        long diff = max - low;

        if(upper - lower < diff) return 0;

        System.out.println((upper - lower ) + " " + diff);

        return (upper - lower ) - (int)diff + 1;
        
    }
}
class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int len = heights.length;

        int[] visibleFromIndex = new int[len];
        Deque<int[]> stk = new ArrayDeque<>(); //0-> height, 1 -> index;

        for(int i = len - 1; i >= 0; --i){
            int count = 0;
            while(!stk.isEmpty() && stk.peek()[0] < heights[i]){
                visibleFromIndex[i]++;
                stk.pop();
            }

            if(stk.size() != 0){
                ++visibleFromIndex[i];
            }

            stk.push(new int[]{heights[i],i});
        }
        return visibleFromIndex;
    }
}
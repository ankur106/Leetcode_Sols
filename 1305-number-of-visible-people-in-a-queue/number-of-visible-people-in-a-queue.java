class Solution {
    public int[] canSeePersonsCount(int[] heights) {

        int len = heights.length;

        int[] canView = new int[len];

        Deque<Integer> st = new ArrayDeque<>();

        st.push(len -1);

        for(int i = len -2 ; i >=0; i--){
            int count = 0;
            while(!st.isEmpty() && heights[st.peek()] <= heights[i]){
                st.pop();
                count++;
            }

        
            canView[i] = count + (st.isEmpty() ? 0 : 1);
            st.push(i);
        }
        
        return canView;
        
    }
}
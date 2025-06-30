class Solution {
    public int[] mostCompetitive(int[] nums, int k) {

        Deque<Integer> st = new ArrayDeque<>();
        int len = nums.length;

        for(int i=0; i < len; ++i){
            while(!st.isEmpty() && st.peek() > nums[i] && (len - i + st.size() > k)){
                st.poll();
            }
            st.push(nums[i]);
        }

        while(st.size() > k){
            st.poll();
        }

        int[] ans = new int[k];
        
        for(int i = k-1; i >=0; --i){
            ans[i] = st.poll();
        }

        return ans;
    }
}
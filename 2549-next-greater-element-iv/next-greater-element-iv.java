class Solution {
    
   public static int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();
        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] >= nums[st.peek()]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                int ind = st.peek();
                arr.get(ind).add(i);
            }
            st.push(i);
        }

        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            for (int ind : arr.get(i)) {
                while (!st.isEmpty() && nums[ind] >= st.peek()) {
                    st.pop();
                }
                if (!st.isEmpty()) {
                    res[ind] = st.peek();
                }
            }
            st.push(nums[i]);
        }

        return res;
    }
    
}
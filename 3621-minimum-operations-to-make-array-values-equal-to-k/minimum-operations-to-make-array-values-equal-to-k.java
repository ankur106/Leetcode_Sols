class Solution {
    public int minOperations(int[] nums, int k) {


        Set<Integer> st = new HashSet<>();
        boolean has = false;



        for(int i : nums){
            if(i < k ) return -1;
            st.add(i);

            if(i==k) has = true;
        }


        return has ? st.size() -1 : st.size();
        
    }
}
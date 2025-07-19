public class Solution {
    public int maxArea(int[] height) {
        int maxarea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int width = right - left;
            maxarea = Math.max(
                maxarea,
                Math.min(height[left], height[right]) * width
            );
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxarea;
    }
}


// class Solution {
//     public int maxArea(int[] height) {
//         int n = height.length;
//         int[] left = new int[n];
//         int[] right = new int[n];

//         Stack<Integer> st = new Stack<>();
//         for (int i = 0; i < n; i++) {
//             while (!st.isEmpty() && height[st.peek()] < height[i]) {
//                 st.pop();
//             }
//             left[i] = st.isEmpty() ? 0 : st.peek();
//             st.push(i);
//         }

//         st.clear();
//         for (int i = n - 1; i >= 0; i--) {
//             while (!st.isEmpty() && height[st.peek()] < height[i]) {
//                 st.pop();
//             }
//             right[i] = st.isEmpty() ? n - 1 : st.peek();
//             st.push(i);
//         }

//         int maxArea = 0;
//         for (int i = 0; i < n; i++) {
//             int width = right[i] - left[i];
//             int area = width * height[i];
//             maxArea = Math.max(maxArea, area);
//         }

//         return maxArea;
//     }
// }
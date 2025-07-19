// do bruteforce first min of max at right and left
// now use monotonic set and precalculate premax and postmax

// can be done via two pointer as well
// then think of single pass

public class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                left_max = Math.max(left_max, height[left]);
                ans += left_max - height[left];
                ++left;
            } else {
                right_max = Math.max(right_max, height[right]);
                ans += right_max - height[right];
                --right;
            }
        }
        System.gc();
        return ans;
    }
}

// public class Solution {
//     public int trap(int[] height) {
//         int ans = 0, current = 0;
//         Deque<Integer> st = new LinkedList<Integer>();
//         while (current < height.length) {
//             while (!st.isEmpty() && height[current] > height[st.peek()]) {
//                 int top = st.peek();
//                 st.pop();
//                 if (st.isEmpty()) break;
//                 int distance = current - st.peek() - 1;
//                 int bounded_height =
//                     Math.min(height[current], height[st.peek()]) - height[top];
//                 ans += distance * bounded_height;
//             }
//             st.push(current++);
//         }
//         return ans;
//     }
// }
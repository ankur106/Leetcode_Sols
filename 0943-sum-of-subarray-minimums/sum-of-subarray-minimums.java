import java.util.*;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] nextSmaller = new int[n];
        int[] prevSmallerOrEqual = new int[n];

        Arrays.fill(prevSmallerOrEqual, -1);
        Arrays.fill(nextSmaller, n);

        Deque<Integer> stack = new ArrayDeque<>();

        // Previous smaller-or-equal and next strictly smaller
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                nextSmaller[stack.pop()] = i;
            }

            if (!stack.isEmpty()) {
                prevSmallerOrEqual[i] = stack.peek();
            }

            stack.push(i);
        }

        long answer = 0;
        long mod = 1_000_000_007L;

        for (int i = 0; i < n; i++) {
            long leftChoices = i - prevSmallerOrEqual[i];
            long rightChoices = nextSmaller[i] - i;

            answer = (answer
                    + leftChoices * rightChoices % mod * arr[i] % mod)
                    % mod;
        }

        return (int) answer;
    }
}
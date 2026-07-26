class Solution {
    public int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int len = digits.length;

        // Find the first decreasing position from the right.
        int pivot = len - 2;

        while (pivot >= 0 && digits[pivot] >= digits[pivot + 1]) {
            pivot--;
        }

        // Digits are already in the greatest arrangement.
        if (pivot < 0) {
            return -1;
        }

        // Find the smallest digit greater than digits[pivot].
        int swapIndex = len - 1;

        while (digits[swapIndex] <= digits[pivot]) {
            swapIndex--;
        }

        // Swap.
        char temp = digits[pivot];
        digits[pivot] = digits[swapIndex];
        digits[swapIndex] = temp;

        // Reverse the suffix.
        reverse(digits, pivot + 1, len - 1);

        // Use long to detect 32-bit integer overflow.
        long result = Long.parseLong(new String(digits));

        return result > Integer.MAX_VALUE ? -1 : (int) result;
    }

    private void reverse(char[] digits, int left, int right) {
        while (left < right) {
            char temp = digits[left];
            digits[left] = digits[right];
            digits[right] = temp;

            left++;
            right--;
        }
    }
}
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length;   // note: n, not n-1

        while (left < right) {
            int mid = left + (right - left) / 2;
            // missing positives before arr[mid] = arr[mid] - (mid + 1)
            if (arr[mid] - mid - 1 >= k) {
                right = mid;        // enough missing → this index could be the boundary
            } else {
                left = mid + 1;     // too few missing → go right
            }
        }
  
        return left + k;
    }
}
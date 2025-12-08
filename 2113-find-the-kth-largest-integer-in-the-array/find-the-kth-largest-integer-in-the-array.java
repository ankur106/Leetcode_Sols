import java.util.Random;

class Solution {
    private static final Random RAND = new Random();

    public String kthLargestNumber(String[] nums, int k) {
        int n = nums.length;
        int target = n - k;
        quickSelect(nums, 0, n - 1, target);
        return nums[target];
    }

    private void quickSelect(String[] nums, int left, int right, int target) {
        while (left <= right) {
            int pivotIndex = randomizedPartition(nums, left, right);

            if (pivotIndex == target) {
                return; // nums[target] is now the kth largest
            } else if (pivotIndex < target) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
    }

    private int randomizedPartition(String[] nums, int left, int right) {
        int pivotIndex = left + RAND.nextInt(right - left + 1);
        swap(nums, pivotIndex, right);
        return partition(nums, left, right);
    }

    private int partition(String[] nums, int left, int right) {
        String pivot = nums[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (compareNumeric(nums[j], pivot) <= 0) {
                swap(nums, i, j);
                i++;
            }
        }

        swap(nums, i, right);
        return i;
    }


    private int compareNumeric(String a, String b) {
        if (a.length() != b.length()) {
            return a.length() - b.length();
        }
        return a.compareTo(b);
    }

    private void swap(String[] nums, int i, int j) {
        String tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
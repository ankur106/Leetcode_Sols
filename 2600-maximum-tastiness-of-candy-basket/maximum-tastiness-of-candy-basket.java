class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int low = 0;
        int high = price[price.length - 1] - price[0];
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canPick(price, k, mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private boolean canPick(int[] price, int k, int minDiff) {
        int last = price[0];
        int count = 1;

        for (int i = 1; i < price.length; i++) {
            if (price[i] - last >= minDiff) {
                count++;
                last = price[i];
                if (count == k) return true;
            }
        }
        return count >= k;
    }
}
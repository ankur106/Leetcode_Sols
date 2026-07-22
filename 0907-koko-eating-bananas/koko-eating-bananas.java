class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, h)) {
                right = mid;        // mid works → try something smaller
            } else {
                left = mid + 1;     // too slow → need faster
            }
        }
        return left;
    }

    private boolean canFinish(int[] piles, int speed, int h) {
        long hours = 0;
        for (int pile : piles) {
            hours += Math.ceil((double) pile / speed);   // ceil(pile / speed)
            if (hours > h) return false;                 // hours only grows, bail early
        }
        return true;
    }
}
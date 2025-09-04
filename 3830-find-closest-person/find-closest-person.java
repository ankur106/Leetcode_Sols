class Solution {
    public int findClosest(int x, int y, int z) {

        int abs1 = Math.abs(x-z);
        int abs2 = Math.abs(y-z);

        return abs1 <= abs2 ? (abs1 == abs2 ? 0 : 1) :2;

    }
}
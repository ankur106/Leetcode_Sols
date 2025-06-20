class Solution {
    public int findMinArrowShots(int[][] points) {
        int len = points.length;

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int nArrows = 1;
        int prevEnd = points[0][1];
        for (int i = 1; i < len; i++) {
    if (points[i][0] > prevEnd) {
        nArrows++;
        prevEnd = points[i][1];
    }
}

        return nArrows;
        
    }
}
class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            int removeStart = toBeRemoved[0], removeEnd = toBeRemoved[1];

            if (end <= removeStart || start >= removeEnd) {
                ans.add(List.of(start, end));
            }
            else {
                if (start < removeStart) {
                    ans.add(List.of(start, removeStart));
                }
                if (end > removeEnd) {
                    ans.add(List.of(removeEnd, end));
                }
            }
        }

        return ans;
    }
}
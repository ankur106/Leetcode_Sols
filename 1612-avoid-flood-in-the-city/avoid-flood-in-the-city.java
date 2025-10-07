

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        TreeSet<Integer> dryDays = new TreeSet<>();
        Map<Integer, Integer> lastRain = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake == 0) {
                dryDays.add(i);
            } else {
                ans[i] = -1;
                if (lastRain.containsKey(lake)) {
                    Integer dryIdx = dryDays.higher(lastRain.get(lake));
                    if (dryIdx == null) return new int[0];
                    ans[dryIdx] = lake;
                    dryDays.remove(dryIdx);
                }
                lastRain.put(lake, i);
            }
        }
        return ans;
    }
}
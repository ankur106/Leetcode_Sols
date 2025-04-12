class Solution {
    public int removeStones(int[][] stones) {
        Map<Integer, Integer> parent = new HashMap<>();
        
        for (int[] stone : stones) {
            int x = stone[0];
            int y = ~stone[1]; // Flip bits to separate row and column space
            union(parent, x, y);
        }

        Set<Integer> uniqueRoots = new HashSet<>();
        for (int[] stone : stones) {
            uniqueRoots.add(find(parent, stone[0]));
        }

        return stones.length - uniqueRoots.size();
    }

    private int find(Map<Integer, Integer> parent, int x) {
        if (!parent.containsKey(x)) {
            parent.put(x, x);
        }
        if (parent.get(x) != x) {
            parent.put(x, find(parent, parent.get(x)));
        }
        return parent.get(x);
    }

    private void union(Map<Integer, Integer> parent, int x, int y) {
        parent.put(find(parent, x), find(parent, y));
    }
}
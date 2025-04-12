class Solution {
    Map<Integer, Integer> parent = new HashMap<>();
    Map<Integer, Integer> size = new HashMap<>();

    public int longestConsecutive(int[] nums) {
        int max = 0;

        for (int num : nums) {
            if (parent.containsKey(num)) continue; // avoid duplicates

            parent.put(num, num);
            size.put(num, 1);

            if (parent.containsKey(num - 1)) union(num, num - 1);
            if (parent.containsKey(num + 1)) union(num, num + 1);

            max = Math.max(max, size.get(findParent(num)));
        }

        return max;
    }

    private int findParent(int node) {
        if (parent.get(node) != node) {
            parent.put(node, findParent(parent.get(node)));
        }
        return parent.get(node);
    }

    private void union(int a, int b) {
        int rootA = findParent(a);
        int rootB = findParent(b);

        if (rootA == rootB) return;

        // Union by size
        if (size.get(rootA) < size.get(rootB)) {
            parent.put(rootA, rootB);
            size.put(rootB, size.get(rootA) + size.get(rootB));
        } else {
            parent.put(rootB, rootA);
            size.put(rootA, size.get(rootA) + size.get(rootB));
        }
    }
}
class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();

        int islands = 0;
        int[] parent = new int[m*n];
        int[] size = new int[m*n];
        int[][] direction = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        Arrays.fill(parent, -1);

        for (int[] position : positions) {
            int r = position[0];
            int c = position[1];

            int root = r * n + c;

            if (parent[root] != -1) {
                ans.add(islands);
                continue;
            }
            parent[root] = root;

            size[root]++;
            islands++;

            for (int[] dir : direction) {
                int neighborR = r + dir[0];
                int neighborC = c + dir[1];
                int neighborUnion = neighborR * n + neighborC;

                if (neighborR < 0 || neighborC < 0 || neighborR >= m || neighborC >= n || parent[neighborUnion] == -1) continue;

                int neighborRoot = find(parent, neighborUnion);
                int parentRoot = find(parent, root);

                if (neighborRoot != parentRoot) {

                    union(parent, size, parentRoot, neighborRoot);
                    islands--;
                }
            }
            ans.add(islands);
        }
        return ans;
    }

    public void union(int[] parent, int[] size, int x, int y) {

        if (size[x] >= size[y]) {
            size[x] += size[y];
            parent[y] = x;
        }
        else {
            size[y] += size[x];
            parent[x] = y;
        }
    }


    public int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}
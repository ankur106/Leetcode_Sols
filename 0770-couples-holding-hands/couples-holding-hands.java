import java.util.*;

class Solution {

    class DSU {
        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            Arrays.fill(size, 1);

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int findParent(int x) {
            if (parent[x] == x) return x;
            return parent[x] = findParent(parent[x]); // path compression
        }

        public void union(int x, int y) {
            int px = findParent(x);
            int py = findParent(y);

            if (px == py) return;

            // union by size
            if (size[px] < size[py]) {
                parent[px] = py;
                size[py] += size[px];
            } else {
                parent[py] = px;
                size[px] += size[py];
            }
        }
    }

    public int minSwapsCouples(int[] row) {
        int n = row.length / 2; // number of couples
        DSU dsu = new DSU(n);

        // Each adjacent seat pair may connect two different couples
        for (int i = 0; i < row.length; i += 2) {
            int couple1 = row[i] / 2;       // couple id of first person
            int couple2 = row[i + 1] / 2;   // couple id of second person
            dsu.union(couple1, couple2);
        }

        int swaps = 0;

        // For each connected component of size k, add k - 1
        for (int i = 0; i < n; i++) {
            if (dsu.findParent(i) == i) {   // only root stores valid component size
                swaps += dsu.size[i] - 1;
            }
        }

        return swaps;
    }
}
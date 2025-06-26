class Solution {
public int earliestAcq(int[][] logs, int n) {
    int[] roots = new int[n];
    for(int i=0; i<roots.length; i++) {
        roots[i] = i;
    }
    
    Arrays.sort(logs, new Comparator<int[]>() {
        public int compare(int[] a, int[] b) {
            return Integer.compare(a[0], b[0]);
        }
    });
    
    for(int i=0; i<logs.length; i++) {
        int rootX = findRoot(logs[i][1], roots);
        int rootY = findRoot(logs[i][2], roots);
        if(rootX != rootY) {
            if(rootX < rootY) {
                roots[rootY] = rootX;
            } else {
                roots[rootX] = rootY;
            }
            n--;
        }
        if(n == 1) {
            return logs[i][0];
        }
        
    }
    if(n == 0) {
        return logs[logs.length-1][0];
    }
    return -1;
}

public int findRoot(int num, int[] roots) {
    while(num != roots[num]) {
        roots[num]= roots[roots[num]];
        num = roots[num];
    }
    return num;
}
}
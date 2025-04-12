class Solution {
    int parent[];
    int size[];

    public int makeConnected(int n, int[][] connections) {
        parent  = new int[n];
        size = new int[n];

        Arrays.fill(size,1);
        for(int i=0 ;  i < n; ++i){
            parent[i] = i;

        }
        int extraCables = 0;
        for(int i =0;  i <connections.length; ++i){
            int edge1 = connections[i][0];
            int edge2 = connections[i][1];
            
            if(findParent(edge1) != findParent(edge2)){
                union(edge1, edge2);
            }else{
                extraCables++;
            }
        }

        int components = findComponents();
        

        if(components -1  <= extraCables){
            return components -1;
        }

        return -1;
    }


    private void union(int e1, int e2){
        
        int parent1 = findParent(e1);
        int parent2 = findParent(e2);

        if(size[parent1] < size[parent2]){
           parent[parent1] = parent2;
           size[parent2] +=size[parent1];
        }else{
            parent[parent2] = parent1;
            size[parent1] += size[parent1];
        }
    }

    private int findParent(int n1) {
        if(n1 == parent[n1]) return n1;

        int pp = findParent(parent[n1]);
        parent[n1] = pp;

        return pp;

    }

    private int findComponents(){
        int ans = 0;

        for(int i=0; i < parent.length; ++i){
            System.out.println(i  + " " + parent[i] );
            if(parent[i]==i) ans++;
        }

        return ans;
    }
}
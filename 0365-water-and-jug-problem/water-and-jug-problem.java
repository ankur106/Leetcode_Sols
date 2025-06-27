class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        int[] arr = new int[]{x, -x, y, -y};

        Queue<Integer> que = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        que.offer(0);

        while(!que.isEmpty()){
            int curr = que.poll();
            if(curr == target) return true;

            for(int i : arr){
                int nw = curr + i;

                if(nw < 0  || nw > x +y || visited.contains(nw)) continue;
                que.offer(nw);
                visited.add(nw);
            }
        }
        return false;    
    }
}
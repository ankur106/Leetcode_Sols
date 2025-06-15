class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();


        for(int i=0; i< numCourses; ++i){
            adj.add(new ArrayList<>());
        }


        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }

        int indegree[] = new int[numCourses];

        for(ArrayList<Integer> li : adj){

            for(int i : li){
                indegree[i]++;
            }
        }

        Queue<Integer> que = new LinkedList<>();

        for(int i=0 ; i < numCourses; ++i){
            if(indegree[i]==0) que.add(i);
        }

        List<Integer> orderedList = new ArrayList<>();
        
        while(que.size() != 0){

            int tmp = que.poll();
            orderedList.add(tmp);
            for(int i : adj.get(tmp)){
                indegree[i]--;
                if(indegree[i] == 0) que.offer(i);

            }

        }

        return orderedList.size() == numCourses;
        
    }
}
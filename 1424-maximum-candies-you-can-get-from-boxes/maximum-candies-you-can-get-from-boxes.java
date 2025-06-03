class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {



        Set<Integer> visited = new HashSet<>();

        int boxes = candies.length;

        int totalCandies = 0;

        Queue<Integer> que = new LinkedList<>();

        for(int initial : initialBoxes){
            que.offer(initial);
            // status[initial] = 1;

        }


        // List<List<Integer>> adjList = new ArrayList<>();

        // for(int i=0;i <n; ++I){
        //     adjList.add(new ArrayList<Integer>());
        // }

        // for(int i=0;i < containedBoxes.size(); ++i){
        //         List<Integer> curr = adjList.get(curr);

        //         for(int box: containedBoxes[i]){
        //             curr.add(box);    
        //         }
        // }

        boolean changed = true;
        while(que.size() > 0 && changed){
                
            
            changed = false;

            int size = que.size();


            for(int i=0;i < size; ++i){
                int box = que.poll();

                if(status[box] == 1){

                    changed = true;
                    totalCandies += candies[box];


                    for(int insideBox : containedBoxes[box]){
                        if(!visited.contains(insideBox)){
                            que.offer(insideBox);
                        }
                    }

                    for(int key : keys[box]){
                        status[key] = 1;
                    }
                    

                }else{
                    que.offer(box);
                }       


            }
            

        }
        return totalCandies;
    }
}
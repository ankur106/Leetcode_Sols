class Solution {
    public long maxKelements(int[] nums, int k) {


        Queue<Integer> minHeap = new PriorityQueue<>();        


        for(int i : nums){
            minHeap.offer(i);

            if(minHeap.size() > k) minHeap.poll();
        }


        long answer = 0;

        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(minHeap);

        while( k > 0){
            int ele = maxHeap.poll();

            answer += ele;
            maxHeap.offer((int) Math.ceil((double)ele/3)); 
            k--;
        }


        return answer;

    }
}
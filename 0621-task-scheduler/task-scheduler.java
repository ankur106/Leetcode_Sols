class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        // Step 1: Frequency map
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Step 2: Max heap to pick the most frequent task
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) maxHeap.add(f);
        }

        // Step 3: Queue for cooldown management [count, available_time]
        Queue<int[]> cooldown = new LinkedList<>();
        int time = 0;

        // Step 4: Simulate each time unit
        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            time++;

            // If task available from cooldown, push back to heap
            if (!cooldown.isEmpty() && cooldown.peek()[1] == time) {
                maxHeap.offer(cooldown.poll()[0]);
            }

            if (!maxHeap.isEmpty()) {
                int count = maxHeap.poll(); // get most frequent task
                count--; // execute task
                if (count > 0) {
                    // put it on cooldown with next available time
                    cooldown.add(new int[]{count, time + n + 1});
                }
            }
            // else CPU is idle for this unit of time
        }

        return time;
    }
}
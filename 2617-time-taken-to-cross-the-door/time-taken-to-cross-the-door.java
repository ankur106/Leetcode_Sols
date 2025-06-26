class Solution {
    public int[] timeTaken(int[] arrival, int[] state) {
        int len = arrival.length;
        int[] crossTime = new int[len];

        Queue<int[]> goIn = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        Queue<int[]> goOut = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        for (int i = 0; i < len; ++i) {
            if (state[i] == 0) {
                goIn.offer(new int[]{arrival[i], i});
            } else {
                goOut.offer(new int[]{arrival[i], i});
            }
        }

        int time = 0;
        int lastCross = 1; 

        while (!goIn.isEmpty() || !goOut.isEmpty()) {
            boolean canGoIn = !goIn.isEmpty() && goIn.peek()[0] <= time;
            boolean canGoOut = !goOut.isEmpty() && goOut.peek()[0] <= time;

            if (canGoIn && canGoOut) {
                if (lastCross == 1) {
                    int[] curr = goOut.poll();
                    crossTime[curr[1]] = time++;
                    lastCross = 1;
                } else {
                    int[] curr = goIn.poll();
                    crossTime[curr[1]] = time++;
                    lastCross = 0;
                }
            } else if (canGoOut) {
                int[] curr = goOut.poll();
                crossTime[curr[1]] = time++;
                lastCross = 1;
            } else if (canGoIn) {
                int[] curr = goIn.poll();
                crossTime[curr[1]] = time++;
                lastCross = 0;
            } else {
        
                if (!goIn.isEmpty() && !goOut.isEmpty()) {
                    time = Math.min(goIn.peek()[0], goOut.peek()[0]);
                } else if (!goIn.isEmpty()) {
                    time = goIn.peek()[0];
                } else if (!goOut.isEmpty()) {
                    time = goOut.peek()[0];
                }
                lastCross = 1;
            }
        }

        return crossTime;
    }
}

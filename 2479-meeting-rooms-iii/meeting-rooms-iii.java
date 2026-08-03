import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        int[] meetingCount = new int[n];

        // Available rooms: smallest room number first
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();

        // Occupied rooms: {endingTime, roomNumber}
        PriorityQueue<long[]> occupiedRooms = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Long.compare(a[0], b[0]);
            }
            return Long.compare(a[1], b[1]);
        });

        for (int room = 0; room < n; room++) {
            availableRooms.offer(room);
        }

        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];
            long duration = end - start;

            // Release every room available by this meeting's start time
            while (!occupiedRooms.isEmpty()
                    && occupiedRooms.peek()[0] <= start) {
                int room = (int) occupiedRooms.poll()[1];
                availableRooms.offer(room);
            }

            int room;
            long newEndTime;

            if (!availableRooms.isEmpty()) {
                // Meeting starts at its original time
                room = availableRooms.poll();
                newEndTime = end;
            } else {
                // Delay the meeting until the earliest room is free
                long[] earliestRoom = occupiedRooms.poll();
                newEndTime = earliestRoom[0] + duration;
                room = (int) earliestRoom[1];
            }

            meetingCount[room]++;
            occupiedRooms.offer(new long[]{newEndTime, room});
        }

        int answer = 0;

        for (int room = 1; room < n; room++) {
            if (meetingCount[room] > meetingCount[answer]) {
                answer = room;
            }
        }

        return answer;
    }
}
import java.util.*;

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        int[] distanceFromA = findDistances(edges, node1);
        int[] distanceFromB = findDistances(edges, node2);

        int answer = -1;
        int minimumMaximumDistance = Integer.MAX_VALUE;

        for (int node = 0; node < n; node++) {
            // Both starting nodes must be able to reach this node
            if (distanceFromA[node] == -1 ||
                distanceFromB[node] == -1) {
                continue;
            }

            int maximumDistance = Math.max(
                distanceFromA[node],
                distanceFromB[node]
            );

            if (maximumDistance < minimumMaximumDistance) {
                minimumMaximumDistance = maximumDistance;
                answer = node;
            }
        }

        return answer;
    }

    private int[] findDistances(int[] edges, int start) {
        int n = edges.length;

        int[] distance = new int[n];
        Arrays.fill(distance, -1);

        int current = start;
        int currentDistance = 0;

        while (current != -1 && distance[current] == -1) {
            distance[current] = currentDistance;
            currentDistance++;

            current = edges[current];
        }

        return distance;
    }
}
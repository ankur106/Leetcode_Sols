import java.util.*;

class Solution {

    static class Edge {
        int node;
        double probability;

        Edge(int node, double probability) {
            this.node = node;
            this.probability = probability;
        }
    }

    static class State {
        int node;
        double probability;

        State(int node, double probability) {
            this.node = node;
            this.probability = probability;
        }
    }

    public double maxProbability(
            int n,
            int[][] edges,
            double[] succProb,
            int startNode,
            int endNode) {

        List<List<Edge>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Undirected graph
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            double probability = succProb[i];

            adjList.get(from).add(new Edge(to, probability));
            adjList.get(to).add(new Edge(from, probability));
        }

        double[] maxProbability = new double[n];
        maxProbability[startNode] = 1.0;

        // Maximum probability should come first
        PriorityQueue<State> maxHeap = new PriorityQueue<>(
            (a, b) -> Double.compare(b.probability, a.probability)
        );

        maxHeap.offer(new State(startNode, 1.0));

        while (!maxHeap.isEmpty()) {
            State current = maxHeap.poll();

            int node = current.node;
            double currentProbability = current.probability;

            // Stale priority queue entry
            if (currentProbability < maxProbability[node]) {
                continue;
            }

            // The first time endNode is removed, its probability is maximum
            if (node == endNode) {
                return currentProbability;
            }

            for (Edge edge : adjList.get(node)) {
                int neighbor = edge.node;

                double newProbability =
                    currentProbability * edge.probability;

                if (newProbability > maxProbability[neighbor]) {
                    maxProbability[neighbor] = newProbability;

                    maxHeap.offer(
                        new State(neighbor, newProbability)
                    );
                }
            }
        }

        return 0.0;
    }
}
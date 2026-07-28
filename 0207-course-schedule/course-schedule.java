class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjLi = new ArrayList<>();

        // One adjacency list for every course
        for (int i = 0; i < numCourses; ++i) {
            adjLi.add(new ArrayList<>());
        }

        // prerequisite[1] must be completed before prerequisite[0]
        for (int[] prerequisite : prerequisites) {
            adjLi.get(prerequisite[1]).add(prerequisite[0]);
        }

        // 0 = unvisited, 1 = currently visiting, 2 = completely visited
        int[] state = new int[numCourses];

        for (int course = 0; course < numCourses; ++course) {
            if (state[course] == 0 && hasCycle(adjLi, state, course)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(
        List<List<Integer>> adjLi,
        int[] state,
        int course
    ) {
        // This node is already in the current DFS path
        if (state[course] == 1) {
            return true;
        }

        // This node was already safely processed
        if (state[course] == 2) {
            return false;
        }

        state[course] = 1;

        for (int child : adjLi.get(course)) {
            if (hasCycle(adjLi, state, child)) {
                return true;
            }
        }

        state[course] = 2;
        return false;
    }
}
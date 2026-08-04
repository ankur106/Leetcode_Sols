class Solution {
    public int openLock(String[] deadends, String target) {
        String start = "0000";

        Set<String> deadNodes = new HashSet<>(Arrays.asList(deadends));

        if (deadNodes.contains(start)) return -1;
        if (target.equals(start)) return 0;

        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        int turns = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                String curr = queue.poll();

                if (curr.equals(target)) {
                    return turns;
                }

                for (int i = 0; i < 4; i++) {
                    char[] chars = curr.toCharArray();
                    char original = chars[i];

                    // Turn forward
                    chars[i] = original == '9'
                            ? '0'
                            : (char) (original + 1);

                    String forward = new String(chars);

                    if (!deadNodes.contains(forward) &&
                        visited.add(forward)) {
                        queue.offer(forward);
                    }

                    // Turn backward
                    chars[i] = original == '0'
                            ? '9'
                            : (char) (original - 1);

                    String backward = new String(chars);

                    if (!deadNodes.contains(backward) &&
                        visited.add(backward)) {
                        queue.offer(backward);
                    }
                }
            }

            turns++;
        }

        return -1;
    }
}
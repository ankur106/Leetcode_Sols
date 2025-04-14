class Solution {
    Map<String, String> emailToName = new HashMap<>();
    Map<String, String> parent = new HashMap<>();
    Map<String, Integer> size = new HashMap<>();

    private void union(String email1, String email2) {
        String p1 = findParent(email1);
        String p2 = findParent(email2);

        if (p1.equals(p2)) return;

        if (size.get(p1) < size.get(p2)) {
            parent.put(p1, p2);
            size.put(p2, size.get(p2) + size.get(p1));
        } else {
            parent.put(p2, p1);
            size.put(p1, size.get(p1) + size.get(p2));
        }
    }

    private String findParent(String email) {
        if (!parent.get(email).equals(email)) {
            parent.put(email, findParent(parent.get(email))); // Path compression
        }
        return parent.get(email);
    }

    private void addEmail(String email, String name) {
        if (!parent.containsKey(email)) {
            parent.put(email, email);
            size.put(email, 1);
            emailToName.put(email, name);
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); ++i) {
                addEmail(account.get(i), name);
                if (i > 1) union(account.get(1), account.get(i));
            }
        }

        // Group emails by their root parent
        Map<String, List<String>> groups = new HashMap<>();
        for (String email : parent.keySet()) {
            String root = findParent(email);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        // Build the result
        List<List<String>> result = new ArrayList<>();
        for (List<String> group : groups.values()) {
            Collections.sort(group);
            group.add(0, emailToName.get(group.get(0)));
            result.add(group);
        }

        return result;
    }
}
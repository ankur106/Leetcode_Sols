class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEnd = false;
}

class AutocompleteSystem {
    private TrieNode root;
    private TrieNode currNode;
    private StringBuilder currSentence;
    private Map<String, Integer> freqMap;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        freqMap = new HashMap<>();
        for (int i = 0; i < sentences.length; i++) {
            addToTrie(sentences[i]);
            freqMap.put(sentences[i], freqMap.getOrDefault(sentences[i], 0) + times[i]);
        }
        currSentence = new StringBuilder();
        currNode = root;
    }

    public List<String> input(char c) {
        if (c == '#') {
            String sentence = currSentence.toString();
            addToTrie(sentence);
            freqMap.put(sentence, freqMap.getOrDefault(sentence, 0) + 1);
            currSentence.setLength(0);
            currNode = root;
            return new ArrayList<>();
        }

        currSentence.append(c);
        if (currNode == null || !currNode.children.containsKey(c)) {
            currNode = null;
            return new ArrayList<>();
        }

        currNode = currNode.children.get(c);
        List<String> candidates = new ArrayList<>();
        dfs(currNode, currSentence.toString(), candidates);

        Collections.sort(candidates, (a, b) -> {
            int freqA = freqMap.get(a);
            int freqB = freqMap.get(b);
            if (freqA == freqB) {
                return a.compareTo(b);
            }
            return freqB - freqA;
        });

        return candidates.size() > 3 ? candidates.subList(0, 3) : candidates;
    }

    private void addToTrie(String sentence) {
        TrieNode node = root;
        for (char c : sentence.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isEnd = true;
    }

    private void dfs(TrieNode node, String path, List<String> result) {
        if (node.isEnd) {
            result.add(path);
        }
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            dfs(entry.getValue(), path + entry.getKey(), result);
        }
    }
}
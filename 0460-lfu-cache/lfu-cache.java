import java.util.*;

class Node {
    int key;
    int val;
    Node prev, next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;
    Map<Integer, Node> map;

    DoublyLinkedList() {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    void addNode(int key, int val) {
        Node n = new Node(key, val);
        n.prev = head;
        n.next = head.next;
        head.next.prev = n;
        head.next = n;
        map.put(key, n);
    }

    Node get(int key) {
        return map.get(key);
    }

    void removeNode(int key) {
        Node n = map.get(key);
        if (n == null) return;
        n.prev.next = n.next;
        n.next.prev = n.prev;
        map.remove(key);
    }

    Node removeLast() {
        if (tail.prev == head) return null;
        Node last = tail.prev;
        removeNode(last.key);
        return last;
    }

    boolean isEmpty() {
        return head.next == tail;
    }
}

class LFUCache {
    TreeMap<Integer, DoublyLinkedList> freqToNodes;
    Map<Integer, Integer> nodeToFreq;
    Map<Integer, Node> keyToNode;
    int capacity;
    int size;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        freqToNodes = new TreeMap<>();
        nodeToFreq = new HashMap<>();
        keyToNode = new HashMap<>();
    }

    public int get(int key) {
        if (!nodeToFreq.containsKey(key)) return -1;

        int freq = nodeToFreq.get(key);
        Node n = freqToNodes.get(freq).get(key);

        freqToNodes.get(freq).removeNode(key);
        if (freqToNodes.get(freq).isEmpty()) freqToNodes.remove(freq);

        nodeToFreq.put(key, freq + 1);
        freqToNodes.computeIfAbsent(freq + 1, k -> new DoublyLinkedList()).addNode(n.key, n.val);
        keyToNode.put(key, freqToNodes.get(freq + 1).get(key));

        return n.val;
    }

    public void put(int key, int val) {
        if (capacity == 0) return;

        if (nodeToFreq.containsKey(key)) {
            // update value
            get(key); // bump frequency
            keyToNode.get(key).val = val;
            return;
        }

        if (size == capacity) {
            int minFreq = freqToNodes.firstKey();
            Node toRemove = freqToNodes.get(minFreq).removeLast();
            if (freqToNodes.get(minFreq).isEmpty()) freqToNodes.remove(minFreq);
            nodeToFreq.remove(toRemove.key);
            keyToNode.remove(toRemove.key);
            size--;
        }

        freqToNodes.computeIfAbsent(1, k -> new DoublyLinkedList()).addNode(key, val);
        nodeToFreq.put(key, 1);
        keyToNode.put(key, freqToNodes.get(1).get(key));
        size++;
    }
}
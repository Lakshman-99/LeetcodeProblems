package amazon;

import java.util.HashMap;

public class LRUCache {
    public static class Node {
        int key;
        int value;
        Node next;
        Node prev;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
    private final int capacity;
    private final HashMap<Integer, Node> map;
    private final Node latest;
    private final Node oldest;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.latest = new Node(-1, -1);
        this.oldest = new Node(-1, -1);
        this.latest.next = oldest;
        this.oldest.prev = latest;
        this.map = new HashMap<>();
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            delete(map.get(key));
        }
        insert(key, value);
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);

        delete(node);
        insert(key, node.value);

        return node.value;
    }

    private void delete(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(node.key);
    }

    private void insert(int key, int value) {
        if(map.size() == capacity) {
            delete(oldest.prev);
        }

        Node node = new Node(key, value);

        node.next = latest.next;
        latest.next.prev = node;

        node.prev = latest;
        latest.next = node;

        map.put(key, node);
    }

    public static void main(String[] args) {
        // Initialize the LRUCache with capacity 2
        LRUCache obj = new LRUCache(2);

        // Perform the operations from the input sequence
        obj.put(1, 1);  // Cache is {1=1}
        obj.put(2, 2);  // Cache is {1=1, 2=2}

        System.out.println(obj.get(1)); // Returns 1, Cache is {2=2, 1=1}

        obj.put(3, 3);  // Evicts key 2, Cache is {1=1, 3=3}
        System.out.println(obj.get(2)); // Returns -1 (not found)

        obj.put(4, 4);  // Evicts key 1, Cache is {3=3, 4=4}
        System.out.println(obj.get(1)); // Returns -1 (not found)
        System.out.println(obj.get(3)); // Returns 3, Cache is {4=4, 3=3}
        System.out.println(obj.get(4)); // Returns 4, Cache is {3=3, 4=4}
    }
}

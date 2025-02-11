import java.util.HashMap;

public class LFUCache {
    public static class Node {
        int key;
        int value;
        int freq;
        Node next;
        Node prev;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
            this.next = null;
            this.prev = null;
        }
    }
    public static class DoubleLL {
        Node head;
        Node tail;
        public DoubleLL() {
            this.head = new Node(-1, -1);
            this.tail = new Node(-1, -1);
            this.head.next = tail;
            this.tail.prev = head;
        }
        public boolean isEmpty() {
            return head.next == tail && tail.prev == head;
        }
    }
    HashMap<Integer, Node> map;
    HashMap<Integer, DoubleLL> list;
    int freq;
    int capacity;

    public LFUCache(int capacity) {
        map = new HashMap<>();
        list = new HashMap<>();
        this.freq = 1;
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node, key, node.value);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            remove(map.get(key));
        }
        if(map.size() >= capacity) {
            remove(list.get(freq).tail.prev);
        }
        insert(map.getOrDefault(key, null), key, value);
    }

    public void remove(Node node) {
        if(node == null) return;
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(Node node, int key, int value) {
        if(node == null) {
            node = new Node(key, value);
            freq = 1;
        } else {
            node.freq += 1;
            node.value = value;
        }
        int nodeFreq = node.freq;

        DoubleLL dll = list.get(nodeFreq);
        if(dll == null) {
            dll = new DoubleLL();
            list.put(nodeFreq, dll);
        }

        node.next = dll.head.next;
        node.next.prev = node;
        dll.head.next = node;
        node.prev = dll.head;

        map.put(key, node);

        if(list.get(freq).isEmpty()) {
            freq++;
        }
    }

    public static void main(String[] args) {
        // Creating an LFUCache instance with a capacity of 3
        LFUCache obj = new LFUCache(2);

        // Performing the operations as per the input
        obj.put(1, 1);       // Put (1, 1)
        obj.put(2, 2);       // Put (2, 2)
        System.out.println(obj.get(1)); // Get key 1, should return 1

        obj.put(3, 3);       // Put (3, 3)
        System.out.println(obj.get(2)); // Get key 2, should return -1 (2 was evicted)

        System.out.println(obj.get(3)); // Get key 3, should return 3
        obj.put(4, 4);       // Put (4, 4) - evicts least frequently used key (1)

        System.out.println(obj.get(1)); // Get key 1, should return -1 (evicted)
        System.out.println(obj.get(3)); // Get key 3, should return 3
        System.out.println(obj.get(4)); // Get key 4, should return 4
    }
}

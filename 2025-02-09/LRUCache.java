import java.util.*;

public class LRUCache {
    public static class Node {
        public int key;
        public int value;
        public Node next;
        public Node prev;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    public HashMap<Integer, Node> map;
    public Node head;
    public Node tail;
    public int capacity;
    public int size;

    public LRUCache(int capacity) {
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.capacity = capacity;
        this.size = 0;
        map = new HashMap<>();
    }

    public int get(int key) {
        if(!map.containsKey(key))
            return -1;

        int ans = map.get(key).value;
        swap(key, ans, map.get(key));
        return ans;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            swap(key, value, map.get(key));
        }
        else if(size >= capacity) {
            map.remove(tail.prev.key);
            map.put(key, tail.prev);
            swap(key, value, tail.prev);
        }
        else {
            Node node = new Node(key, value);

            if (head.next == null) {
                node.next = tail;
                head.next = node;
                tail.prev = node;
            } else {
                Node temp = head.next;
                node.next = temp;
                head.next = node;
                temp.prev = node;
            }

            map.put(key, node);
            size++;
        }
    }

    private void swap(int key, int value, Node n) {
        if(head.next == n) {
            n.key = key;
            n.value = value;
            return;
        }

        Node prev = n.prev;
        Node next = n.next;

        prev.next = next;
        next.prev = prev;

        n.key = key;
        n.value = value;

        n.next = head.next;
        head.next.prev = n;
        head.next = n;
        n.prev = null;
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

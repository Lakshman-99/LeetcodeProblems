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

    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {

        }
        else {
            if(size >= capacity) {
                swap(key, value);
            }
            else {
                Node node = new Node(key, value);

                if (head.next == null) {
                    head.next = node;
                    tail.prev = node;
                } else {
                    node.next = head.next;
                    head.next = node;
                }

                map.put(key, node);
                size++;
            }
        }
    }

    private void swap(int key, int value) {
        Node temp = tail.prev;

        Node prev = temp.prev;

        tail.prev = prev;
        prev.next = null;

        temp.key = key;
        temp.value = value;
        


    }
}

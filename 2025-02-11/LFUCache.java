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
            return head.next == tail;
        }

        public void addToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        public void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    HashMap<Integer, Node> map;
    HashMap<Integer, DoubleLL> freqMap;
    int minFreq;
    int capacity;

    public LFUCache(int capacity) {
        this.map = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.minFreq = 1;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        updateNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            updateNode(node);
        } else {
            if (map.size() >= capacity) {
                DoubleLL minFreqList = freqMap.get(minFreq);
                Node toRemove = minFreqList.tail.prev;
                minFreqList.removeNode(toRemove);
                map.remove(toRemove.key);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            DoubleLL newList = freqMap.getOrDefault(1, new DoubleLL());
            newList.addToHead(newNode);
            freqMap.put(1, newList);
            minFreq = 1;
        }
    }

    private void updateNode(Node node) {
        int currentFreq = node.freq;
        DoubleLL currentList = freqMap.get(currentFreq);
        currentList.removeNode(node);

        if (currentFreq == minFreq && currentList.isEmpty()) {
            minFreq++;
        }

        node.freq++;
        DoubleLL newList = freqMap.getOrDefault(node.freq, new DoubleLL());
        newList.addToHead(node);
        freqMap.put(node.freq, newList);
    }

    public static void main(String[] args) {
        // Initialize the cache with capacity 10
        LFUCache cache = new LFUCache(10);

        // Arrays of operations and values
        String[] operations = {
                "put", "put", "put", "put", "put", "get", "put", "get", "get", "put",
                "get", "put", "put", "put", "get", "put", "get", "get", "get", "get",
                "put", "put", "get", "get", "get", "put", "put", "get", "put", "get",
                "put", "get", "get", "get", "put", "put", "put", "get", "put", "get",
                "get", "put", "put", "get", "put", "put", "put", "put", "get", "put",
                "put", "get", "put", "put", "get", "put", "put", "put", "put", "put",
                "get", "put", "put", "get", "put", "get", "get", "get", "put", "get",
                "get", "put", "put", "put", "put", "get", "put", "put", "put", "put",
                "get", "get", "get", "put", "put", "put", "get", "put", "put", "put",
                "get", "put", "put", "put", "get", "get", "get", "put", "put", "put",
                "put", "get", "put", "put", "put", "put", "put", "put", "put"
        };

        int[][] values = {
                {10, 13}, {3, 17}, {6, 11}, {10, 5}, {9, 10}, {13}, {2, 19}, {2}, {3}, {5, 25},
                {8}, {9, 22}, {5, 5}, {1, 30}, {11}, {9, 12}, {7}, {5}, {8}, {9},
                {4, 30}, {9, 3}, {9}, {10}, {10}, {6, 14}, {3, 1}, {3}, {10, 11}, {8},
                {2, 14}, {1}, {5}, {4}, {11, 4}, {12, 24}, {5, 18}, {13}, {7, 23}, {8},
                {12}, {3, 27}, {2, 12}, {5}, {2, 9}, {13, 4}, {8, 18}, {1, 7}, {6}, {9, 29},
                {8, 21}, {5}, {6, 30}, {1, 12}, {10}, {4, 15}, {7, 22}, {11, 26}, {8, 17}, {9, 29},
                {5}, {3, 4}, {11, 30}, {12}, {4, 29}, {3}, {9}, {6}, {3, 4}, {1}, {10},
                {3, 29}, {10, 28}, {1, 20}, {11, 13}, {3}, {3, 12}, {3, 8}, {10, 9}, {3, 26}, {8},
                {7}, {5}, {13, 17}, {2, 27}, {11, 15}, {12}, {9, 19}, {2, 15}, {3, 16}, {1},
                {12, 17}, {9, 1}, {6, 19}, {4}, {5}, {5}, {8, 1}, {11, 7}, {5, 2}, {9, 28},
                {1}, {2, 2}, {7, 4}, {4, 22}, {7, 24}, {9, 26}, {13, 28}, {11, 26}
        };

        // Process each operation
        for (int i = 0; i < operations.length; i++) {
            String operation = operations[i];
            int[] value = values[i];

            if (operation.equals("put")) {
                cache.put(value[0], value[1]);
            } else if (operation.equals("get")) {
                int result = cache.get(value[0]);
                System.out.println(result + "  -> get(" + value[0] + ")");
            }
        }
    }
}
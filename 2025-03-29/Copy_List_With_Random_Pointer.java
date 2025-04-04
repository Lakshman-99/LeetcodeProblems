package amazon;

import java.util.HashMap;

public class Copy_List_With_Random_Pointer {
    public class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;

        while(cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;

        while(cur != null) {
            Node copy = map.get(cur);
            copy.next = map.get(cur.next);
            copy.random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }
    public static void main(String[] args) {

    }
}

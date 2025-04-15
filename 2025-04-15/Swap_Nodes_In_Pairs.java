public class Swap_Nodes_In_Pairs {
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + (current.next != null ? " -> " : ""));
            current = current.next;
        }
    }
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode node = head.next, cur = head, prev = null;

        while(cur != null && cur.next != null) {
            ListNode nxtNode = cur.next;
            cur.next  = nxtNode.next;
            nxtNode.next = cur;

            if(prev != null) {
                prev.next = nxtNode;
            }
            prev = cur;
            cur = cur.next;
        }

        return node;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);

        printList(swapPairs(head.next));
    }
}

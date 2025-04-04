package amazon;

public class Reorder_List {
    static public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void reorderList(ListNode head) {
        if(head == null) return;

        // find mid
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half
        ListNode prev = null;
        while(slow.next != null) {
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        slow.next = prev;

        // Reorder
        ListNode n1 = head, n2 = slow;
        while(n2.next != null) {
            ListNode temp1 = n1.next, temp2 = n2.next;
            n1.next = n2;
            n2.next = temp1;
            n1 = temp1;
            n2 = temp2;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reorderList(head);

        while(head != null) {
            System.out.println(head.val);
            head=head.next;
        }
    }
}

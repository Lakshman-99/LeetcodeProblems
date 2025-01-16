public class Rotate_List {
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + (current.next != null ? " -> " : ""));
            current = current.next;
        }
    }
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;

        int n = 0;
        ListNode temp = head;

        while(temp != null) {
            temp = temp.next;
            n++;
        }
        k %= n;
        if(k == 0) return head;

        temp = head;

        for(int i=1;i<n-k;i++) {
            temp = temp.next;
        }

        ListNode newHead = temp.next;
        temp.next = null;
        temp = newHead;

        while(temp.next != null)
            temp = temp.next;

        temp.next = head;

        return newHead;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Print the list to verify
        printList(head);
        ListNode reverse = rotateRight(head, 22);
        System.out.println();
        printList(reverse);

    }
}

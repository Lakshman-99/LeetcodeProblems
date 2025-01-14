public class Middle_Of_The_Linked_List {
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + (current.next != null ? " -> " : ""));
            current = current.next;
        }
    }
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);

        // Print the list to verify
        printList(head);
        ListNode reverse = middleNode(head);
        System.out.println();
        printList(reverse);

    }
}

public class Remove_Duplicates_From_Sorted_List {
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + (current.next != null ? " -> " : ""));
            current = current.next;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;

        ListNode prev = head, cur = head.next;
        while(cur != null) {
            if(prev.val == cur.val) {
                prev.next = cur.next;
            }
            else {
                prev = cur;
            }
            cur = cur.next;
        }

        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        // Print the list to verify
        printList(head);
        ListNode reverse = deleteDuplicates(head);
        System.out.println();
        printList(reverse);

    }
}

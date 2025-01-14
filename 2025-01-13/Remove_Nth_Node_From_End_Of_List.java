// 19. Remove Nth Node From End of List

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description

public class Remove_Nth_Node_From_End_Of_List {
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + (current.next != null ? " -> " : ""));
            current = current.next;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;

        for(int i=0;i<n;i++)
            fast = fast.next;

        if(fast == null) return head.next;

        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        // Print the list to verify
        printList(head);
        ListNode reverse = removeNthFromEnd(head, 1);
        System.out.println();
        printList(reverse);

    }
}

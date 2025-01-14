// 206. Reverse Linked List

// https://leetcode.com/problems/reverse-linked-list/description

public class Reverse_Linked_List {
    // Helper function to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + (current.next != null ? " -> " : ""));
            current = current.next;
        }
    }
    public static ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode prev = null;

        while(head.next != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        head.next = prev;

        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Print the list to verify
        printList(head);
        ListNode reverse = reverseList(head);
        System.out.println();
        printList(reverse);

    }
}

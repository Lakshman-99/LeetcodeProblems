// 234. Palindrome Linked List

// https://leetcode.com/problems/palindrome-linked-list/description

public class Palindrome_Linked_List {
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + (current.next != null ? " -> " : ""));
            current = current.next;
        }
    }
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, temp, prev;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        temp = slow;
        prev = null;

        while(temp != null) {
            ListNode t = temp.next;
            temp.next = prev;
            prev = temp;
            temp = t;
        }

        fast = head;
        slow = prev;

        while(slow != null) {
            if(fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        // Print the list to verify
        printList(head);
        System.out.println(isPalindrome(head));
    }
}

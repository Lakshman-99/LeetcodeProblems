// 142. Linked List Cycle II

// https://leetcode.com/problems/linked-list-cycle-ii/description

public class Linked_List_Cycle_II {
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + (current.next != null ? " -> " : ""));
            current = current.next;
        }
    }
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head, entry = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                while(slow != entry) {
                    slow = slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }

        return null;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next = head.next;

        // Print the list to verify
//        printList(head);
        ListNode mergedList = detectCycle(head);
        printList(mergedList);
    }
}

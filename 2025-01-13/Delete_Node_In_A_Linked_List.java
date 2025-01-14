// 237. Delete Node in a Linked List

// https://leetcode.com/problems/delete-node-in-a-linked-list/description

public class Delete_Node_In_A_Linked_List {
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + (current.next != null ? " -> " : ""));
            current = current.next;
        }
    }
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Print the list to verify
        printList(head);
        deleteNode(head.next.next.next);
        System.out.println();
        printList(head);

    }
}

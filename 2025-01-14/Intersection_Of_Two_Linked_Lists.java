public class Intersection_Of_Two_Linked_Lists {
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + (current.next != null ? " -> " : ""));
            current = current.next;
        }
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headB == null || headA == null) return null;

        ListNode p1 = headA, p2 = headB;
        while(p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }

        return p1;
    }
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));

        // Create list2: [1,3,4]
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        // Print the list to verify
        printList(list1);
        printList(list2);
        ListNode mergedList = getIntersectionNode(list1, list2);
        System.out.println();
        printList(mergedList);
    }
}

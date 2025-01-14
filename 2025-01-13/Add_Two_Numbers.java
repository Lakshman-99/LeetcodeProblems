// 2. Add Two Numbers

// https://leetcode.com/problems/add-two-numbers/description

public class Add_Two_Numbers {
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + (current.next != null ? " -> " : ""));
            current = current.next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode temp = ans;
        int carry = 0;

        while(l1 != null || l2 != null || carry > 0) {
            int d1 = l1 != null ? l1.val : 0;
            int d2 = l2 != null ? l2.val : 0;

            int sum = d1 + d2 + carry;
            ans.next = new ListNode(sum % 10);

            carry = sum / 10;

            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
            ans = ans.next;
        }

        return temp.next;
    }
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));

        // Create list2: [1,3,4]
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        // Print the list to verify
        printList(list1);
        printList(list2);
        ListNode mergedList = addTwoNumbers(list1, list2);
        System.out.println();
        printList(mergedList);

    }
}

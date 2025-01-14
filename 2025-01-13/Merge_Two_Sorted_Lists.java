// 21. Merge Two Sorted Lists

// https://leetcode.com/problems/merge-two-sorted-lists/description

public class Merge_Two_Sorted_Lists {
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + (current.next != null ? " -> " : ""));
            current = current.next;
        }
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode();
        ListNode ans = temp;

        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                ans.next = list1;
                list1 = list1.next;
            }
            else {
                ans.next = list2;
                list2 = list2.next;
            }

            ans = ans.next;
        }

        ans.next = (list1 != null) ? list1 : list2;

        return temp.next;
    }
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));

        // Create list2: [1,3,4]
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        // Print the list to verify
        printList(list1);
        printList(list2);
        ListNode mergedList = mergeTwoLists(list1, list2);
        System.out.println();
        printList(mergedList);

    }
}

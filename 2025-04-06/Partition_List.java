package amazon;

import java.util.List;

public class Partition_List {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode partition(ListNode head, int x) {
        ListNode slist = new ListNode();
        ListNode blist = new ListNode();
        ListNode small = slist;
        ListNode big = blist;

        while(head!=null) {
            if(head.val < x) {
                small.next = head;
                small = small.next;
            }
            else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        small.next = blist.next;
        big.next = null;

        return slist.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        ListNode ans = partition(head, 3);

        while (ans != null) {
            System.out.println(ans.val);
            ans=ans.next;
        }
    }
}

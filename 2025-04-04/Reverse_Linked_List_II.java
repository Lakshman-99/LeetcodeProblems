package amazon;

import java.util.List;

public class Reverse_Linked_List_II {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode cur = head, prev = null;
        while(cur != null) {
            if(cur.val == left && left != right) {
                ListNode runPrev = cur, run = cur.next, last = cur;
                while(run != null) {
                    ListNode temp = run.next;
                    run.next = runPrev;

                    runPrev = run;
                    run = temp;

                    if(runPrev.val == right)
                        break;
                }
                if(prev != null) {
                    prev.next = runPrev;
                }
                else {
                    head = runPrev;
                }
                last.next = run;
                cur =run;
            }
            else {
                prev = cur;
                cur = cur.next;
            }
        }

        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode ans = reverseBetween(head, 1, 5);

        while(ans!=null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}

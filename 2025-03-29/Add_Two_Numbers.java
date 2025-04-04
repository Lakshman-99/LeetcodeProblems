package amazon;

public class Add_Two_Numbers {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            ans = ans.next;
        }

        return temp.next;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        addTwoNumbers(l1, l2);
    }
}

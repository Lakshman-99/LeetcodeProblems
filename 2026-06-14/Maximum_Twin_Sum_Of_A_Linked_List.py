from typing import Optional

from Linked_List import ListNode, Linked_List

class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        pre = None
        slow = fast = head
        while fast and fast.next:
            pre = slow
            slow = slow.next
            fast = fast.next.next

        prev, cur = None, slow
        while cur:
            tmp = cur.next
            cur.next = prev
            prev = cur
            cur = tmp

        pre.next = None
        ans = 0
        while pre and head:
            ans = max(ans, head.val + prev.val)
            head = head.next
            prev = prev.next

        return ans


sol = Solution()
sll = Linked_List()
print(sol.pairSum(sll.build_from_list([5,4,2,1])))
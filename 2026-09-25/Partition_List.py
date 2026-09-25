from typing import Optional

from Linked_List import ListNode, Linked_List

class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        if not head:
            return None

        before = bh = ListNode(-1)
        after = ah = ListNode(-1)

        while head:
            if head.val < x:
                before.next = head
                before = before.next
            else:
                after.next = head
                after = after.next
            head = head.next

        after.next = None
        before.next = ah.next

        return bh.next


sol = Solution()
sll = Linked_List()
print(sol.partition(sll.build_from_list([1,4,3,2,5,2]), 3))

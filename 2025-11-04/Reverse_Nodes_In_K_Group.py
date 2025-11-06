from typing import Optional

from Linked_List import ListNode, Linked_List


class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head or k == 1:
            return head

        dummy = ListNode(0)
        dummy.next = head
        curr = head
        prev = dummy

        count = 0
        while curr:
            count += 1
            curr = curr.next

        while count >= k:
            curr = prev.next
            next = curr.next

            for _ in range(1, k):
                curr.next = next.next
                next.next = prev.next
                prev.next = next
                next = curr.next

            prev = curr
            count -= k

        return dummy.next

sol = Solution()

sll = Linked_List()

node = sol.reverseKGroup(sll.build_from_list([1,2,3,4,5,6]), 3)
sll.print_list(node)
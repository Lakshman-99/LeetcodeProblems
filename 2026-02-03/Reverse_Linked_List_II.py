from typing import Optional
from Linked_List import Linked_List, ListNode


class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        copy = ListNode(0, head)
        prev = copy
        start = head
        ind = 1

        while start and ind != left:
            start = start.next
            prev = prev.next
            ind += 1

        revPrev = None
        cur = start

        while cur and ind <= right:
            temp = cur.next
            cur.next = revPrev
            revPrev = cur
            cur = temp
            ind += 1

        prev.next = revPrev
        start.next = cur
        return copy.next


sol = Solution()
ll = Linked_List()
head = ll.build_from_list([3,5])
ll.print_list(sol.reverseBetween(head, 1, 2))
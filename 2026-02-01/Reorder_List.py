from typing import Optional
from Linked_List import Linked_List, ListNode


class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        if not head:
            return

        slow, fast = head, head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        cur = slow.next
        prev = slow.next = None

        while cur:
            temp = cur.next
            cur.next = prev
            prev = cur
            cur = temp

        first, second = head, prev
        while second:
            temp1, temp2 = first.next, second.next
            first.next = second
            second.next = temp1
            first, second = temp1, temp2

        return


sol = Solution()
ll = Linked_List()
head = ll.build_from_list([1,2,3,4,])
sol.reorderList(head)
ll.print_list(head)
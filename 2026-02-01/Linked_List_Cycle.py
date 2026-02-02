from typing import Optional
from Linked_List import Linked_List, ListNode


class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        if not head:
            return False

        slow, fast = head, head.next

        while fast and fast.next:
            if slow == fast:
                return True

            slow = slow.next
            fast = fast.next.next

        return False


sol = Solution()
ll = Linked_List()
head = ll.build_from_list([1,2,3,4,5])
ll.print_list(sol.hasCycle(head))
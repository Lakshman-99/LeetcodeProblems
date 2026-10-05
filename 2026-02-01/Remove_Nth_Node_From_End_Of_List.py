from typing import Optional
from Linked_List import Linked_List, ListNode


class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        total = 0
        cur = head
        while cur:
            cur = cur.next
            total += 1

        n = total - n + 1
        cur = head
        if n == 1:
            return cur.next

        ind = 1
        while cur.next:
            if ind + 1 == total == n:
                cur.next = None
                break

            if ind + 1 == n:
                cur.next = cur.next.next
                break

            cur = cur.next
            ind += 1

        return head


sol = Solution()
ll = Linked_List()
head = ll.build_from_list([1,2,3,4,5])
ll.print_list(sol.removeNthFromEnd(head, 2))
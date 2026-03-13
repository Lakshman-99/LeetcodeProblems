from typing import Optional
from leetcode.linked_list.Linked_List import Linked_List, ListNode


class Solution:
    def insertGreatestCommonDivisors(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return None

        def gcd(a, b):
            while b > 0:
                a, b = b, a % b

            return a

        prev, cur = head, head.next
        while cur is not None:
            newNode = ListNode(gcd(prev.val, cur.val))
            prev.next = newNode
            newNode.next = cur

            prev = cur
            cur = cur.next

        return head


sol = Solution()
ll = Linked_List()
head = ll.build_from_list([18,6,10,3])
sol.insertGreatestCommonDivisors(head)
ll.print_list(head)
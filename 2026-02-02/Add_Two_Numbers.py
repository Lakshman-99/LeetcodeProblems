from typing import Optional
from Linked_List import Linked_List, ListNode


class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        result = ListNode(0)
        cur = result
        carry = 0

        while l1 or l2 or carry:
            sum = carry
            if l1:
                sum += l1.val
                l1 = l1.next
            if l2:
                sum += l2.val
                l2 = l2.next

            carry = sum // 10
            cur.next = ListNode(sum % 10)
            cur = cur.next

        return result.next


sol = Solution()
ll = Linked_List()
head1 = ll.build_from_list([2,4,3])
head2 = ll.build_from_list([5,6,4])
ll.print_list(sol.addTwoNumbers(head1, head2))
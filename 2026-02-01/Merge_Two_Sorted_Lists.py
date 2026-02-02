from typing import Optional
from Linked_List import Linked_List, ListNode


class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        head = ListNode(0)
        cur = head

        while list1 and list2:
            if list1.val <= list2.val:
                cur.next = list1
                list1 = list1.next
            else:
                cur.next = list2
                list2 = list2.next

            cur = cur.next

        cur.next = list1 or list2

        return head.next


sol = Solution()
ll = Linked_List()
head1 = ll.build_from_list([1,2,4])
head2 = ll.build_from_list([1,3,4])
ll.print_list(sol.mergeTwoLists(head1, head2))
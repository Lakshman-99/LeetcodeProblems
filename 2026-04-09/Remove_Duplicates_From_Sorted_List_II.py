from typing import Optional

from Linked_List import ListNode, Linked_List


class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head

        dummy = ListNode(0)
        temp, cur = dummy, head
        prev = ListNode(-101)

        while cur.next:
            if cur.val != cur.next.val and cur.val != prev.val:
                temp.next = cur
                temp = temp.next

            prev = cur
            cur = cur.next

        if prev.val != cur.val:
            temp.next = cur
        else:
            temp.next = None

        return dummy.next

sol = Solution()
sll = Linked_List()

node = sol.deleteDuplicates(sll.build_from_list([1,1]))
sll.print_list(node)
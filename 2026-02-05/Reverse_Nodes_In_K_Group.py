from typing import Optional

from Linked_List import ListNode


class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head or k == 1:
            return head

        dummy = ListNode(0, head)
        grpPrev = dummy

        while True:
            kth = self.getKth(grpPrev, k)
            if not kth:
                break

            grpNext = kth.next
            prev, cur = kth.next, grpPrev.next
            while cur != grpNext:
                temp = cur.next
                cur.next = prev
                prev = cur
                cur = temp

            temp = grpPrev.next
            grpPrev.next = prev
            grpPrev = temp

        return dummy.next

    def getKth(self, head, k):
        count = 1
        while head and count <= k:
            head = head.next
            count += 1

        return head
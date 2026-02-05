from typing import Optional

from Linked_List import ListNode


class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head or k == 1:
            return head

        dummy = ListNode(0, head)
        grpPrev = dummy
        count = 0

        cur = dummy.next
        while cur is not None:
            count += 1
            cur = cur.next

        while count >= k:
            cur = grpPrev.next
            kth = self.getKth(grpPrev, k)
            prev = kth.next if kth else None

            while cur != kth:
                temp = cur.next
                cur.next = prev
                prev = cur
                cur = temp

            grpPrev.next = prev
            grpPrev = kth

        return dummy.next

    def getKth(self, head, k):
        count = 1
        while head and count <= k:
            head = head.next
            count += 1

        return head
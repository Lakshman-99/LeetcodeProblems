from typing import List, Optional

from Linked_List import ListNode


class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists or not len(lists):
            return None

        while len(lists) > 1:
            merged_lists = []
            for i in range(0, len(lists), 2):
                l1 = lists[i]
                l2 = lists[i+1] if i+1 < len(lists) else None
                merged_lists.append(self.merge_list(l1, l2))
            lists = merged_lists

        return lists[0]

    def merge_list(self, head1, head2):
        dummy = ListNode(0)
        cur = dummy

        while head1 and head2:
            if head1.val < head2.val:
                cur.next = head1
                head1 = head1.next
            else:
                cur.next = head2
                head2 = head2.next

            cur = cur.next

        cur.next = head1 or head2
        return dummy.next
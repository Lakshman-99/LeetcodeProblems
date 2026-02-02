from typing import Optional
from Linked_List import Linked_List, ListNode


class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prevNode, curNode = None, head

        while curNode:
            nextNode = curNode.next
            curNode.next = prevNode
            prevNode = curNode
            curNode = nextNode

        return prevNode


sol = Solution()
ll = Linked_List()
head = ll.build_from_list([1,2,3,4,5])
ll.print_list(sol.reverseList(head))
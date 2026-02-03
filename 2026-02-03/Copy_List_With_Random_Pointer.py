from typing import Optional
from Linked_List import Linked_List, ListNode

class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None

        cur = head
        while cur:
            node = Node(cur.val)
            node.next = cur.random
            cur.random = node
            cur = cur.next

        newHead = head.random
        cur = head
        while cur:
            node = cur.random
            node.random = node.next.random if node.next else None
            cur = cur.next

        cur = head
        while cur:
            node = cur.random
            cur.random = node.next
            node.next = cur.next.random if cur.next else None
            cur = cur.next

        return newHead


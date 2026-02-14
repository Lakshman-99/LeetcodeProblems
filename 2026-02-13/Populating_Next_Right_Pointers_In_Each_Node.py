from collections import deque
from typing import Optional, List
from Tree import TreeNode, Tree

class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return None

        q = deque([root])
        while q:
            curList = []
            curLen = len(q)
            for _ in range(curLen):
                node = q.popleft()
                curList.append(node)

                if node.left:
                    q.append(node.left)

                if node.right:
                    q.append(node.right)

            n = len(curList)
            for i in range(n):
                curList[i].next = curList[i+1] if i+1 < n else None

        return root
from collections import deque
from typing import Optional, List
from Tree import TreeNode, Tree

class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if not root:
            return False

        q = deque([(root, None)])
        while q:
            curList = []
            curLen = len(q)
            for _ in range(curLen):
                node, parent = q.popleft()
                if parent and (node.val == x or node.val == y):
                    curList.append(parent.val)

                if node.left:
                    q.append((node.left, node))

                if node.right:
                    q.append((node.right, node))

            if len(curList) == 2:
                return curList[0] != curList[1]
            if len(curList) == 1:
                return False

        return False

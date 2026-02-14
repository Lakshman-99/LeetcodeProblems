from collections import deque
from typing import Optional, List
from Tree import TreeNode, Tree

class Solution:
    def averageOfLevels(self, root: Optional[TreeNode]) -> List[float]:
        result = []
        if not root:
            return result

        q = deque([root])
        while q:
            s = c = 0
            curLen = len(q)
            for _ in range(curLen):
                node = q.popleft()
                s += node.val
                c += 1.0

                if node.left:
                    q.append(node.left)

                if node.right:
                    q.append(node.right)

            result.append(s / c)

        return result
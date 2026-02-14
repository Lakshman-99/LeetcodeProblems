from collections import deque
from typing import Optional, List
from Tree import TreeNode, Tree


class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        result = []
        if not root:
            return result

        q = deque([root])
        while q:
            curList = []
            curLen = len(q)
            for _ in range(curLen):
                node = q.popleft()
                curList.append(node.val)

                if node.left:
                    q.append(node.left)

                if node.right:
                    q.append(node.right)

            result.append(curList)

        return result


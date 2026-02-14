from collections import deque
from typing import Optional, List
from Tree import TreeNode, Tree


class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
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

                for child in node.children:
                    if child:
                        q.append(child)

            result.append(curList)

        return result
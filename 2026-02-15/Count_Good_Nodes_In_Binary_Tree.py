from collections import deque
from typing import Optional, List
from Tree import TreeNode, Tree


class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        answer = 0

        def dfs(node, curMax):
            nonlocal answer
            if not node:
                return

            if node.val >= curMax:
                answer += 1

            curMax = max(curMax, node.val)
            dfs(node.left, curMax)
            dfs(node.right, curMax)
            return

        dfs(root, root.val)
        return answer

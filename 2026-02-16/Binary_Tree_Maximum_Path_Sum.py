from collections import deque
from typing import Optional, List
from Tree import TreeNode, Tree


class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        max_sum = root.val

        def dfs(node):
            nonlocal max_sum

            if not node:
                return 0

            left = max(0, dfs(node.left))
            right = max(0, dfs(node.right))
            max_sum = max(max_sum, node.val + left + right)

            return node.val + max(left, right)

        dfs(root)
        return max_sum


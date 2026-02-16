from collections import deque
from typing import Optional, List
from Tree import TreeNode, Tree


class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        def dfs(node):
            if not node:
                return 0, 0

            left = dfs(node.left)
            right = dfs(node.right)

            with_root = node.val + left[1] + right[1]
            without_root = max(left) + max(right)

            return [with_root, without_root]

        return max(dfs(root))


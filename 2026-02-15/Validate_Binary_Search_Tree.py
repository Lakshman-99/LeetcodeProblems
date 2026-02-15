from collections import deque
from typing import Optional, List
from Tree import TreeNode, Tree


class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def dfs(node, left, right):
            if not node:
                return True

            if not (left < node.val < right):
                return False

            return dfs(node.left, left, node.val) and dfs(node.right, node.val, right)

        return dfs(root, float('-inf'), float('inf'))


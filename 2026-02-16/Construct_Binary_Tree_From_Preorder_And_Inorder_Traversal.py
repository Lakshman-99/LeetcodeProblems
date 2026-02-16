from collections import deque
from typing import Optional, List
from Tree import TreeNode, Tree


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        io = {val: ind for ind, val in enumerate(inorder)}
        p_idx = 0

        def dfs(l, r):
            nonlocal p_idx
            if l > r:
                return None

            root = TreeNode(preorder[p_idx])
            mid = io[preorder[p_idx]]
            p_idx += 1
            root.left = dfs(l, mid - 1)
            root.right = dfs(mid + 1, r)
            return root

        return dfs(0, len(preorder) - 1)
from collections import deque
from typing import Optional, List
from Tree import TreeNode, Tree


class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        cur_k = k
        answer = 0
        def dfs(node):
            nonlocal cur_k, answer
            if not node:
                return

            dfs(node.left)
            cur_k -= 1
            if cur_k == 0:
                answer = node.val
                return
            dfs(node.right)

        dfs(root)
        return answer

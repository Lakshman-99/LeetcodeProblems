from collections import deque
from typing import Optional, List
from Tree import TreeNode, Tree


class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        if not root:
            return 0

        left = self.kthSmallest(root.left, k)
        right = self.kthSmallest(root.right, k)

        if k == left + right:
            return
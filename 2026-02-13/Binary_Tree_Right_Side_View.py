from collections import deque
from typing import Optional, List
from Tree import TreeNode, Tree


class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []

        def preorder(node, level):
            if not node:
                return

            if level == len(result):
                result.append(node.val)

            preorder(node.right, level+1)
            preorder(node.left, level+1)

        preorder(root, 0)
        return result
from collections import deque
from typing import Optional, List

from TreeNode import TreeNode
from Tree import Tree


class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        if not root:
            return True

        def dfs(root):
            if not root:
                return 0

            l = dfs(root.left)
            r = dfs(root.right)

            return 1 + max(l, r)

        return dfs(root)


sol = Solution()
tree = Tree()
node = tree.array_to_tree([3,1,None,None,2])
print(sol.diameterOfBinaryTree(node))

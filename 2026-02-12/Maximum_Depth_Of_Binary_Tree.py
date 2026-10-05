from typing import Optional, List
from Tree import TreeNode, Tree


class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        return 1 + max(self.maxDepth(root.left), self.maxDepth(root.right))



sol = Solution()
tree = Tree()
node = tree.array_to_tree([3,9,20,None,None,15,7])
print(sol.maxDepth(node))

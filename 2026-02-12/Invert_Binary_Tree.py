from typing import Optional, List
from Tree import TreeNode, Tree


class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return None

        root.left, root.right = root.right, root.left

        self.invertTree(root.left)
        self.invertTree(root.right)

        return root


sol = Solution()
tree = Tree()
node = tree.array_to_tree([4,2,7,1,3,6,9])
print(sol.invertTree(node))

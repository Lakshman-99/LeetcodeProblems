from typing import Optional, List
from Tree import TreeNode, Tree


class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        isBalanced = True
        def checkBalanced(node):
            nonlocal isBalanced

            if not node:
                return 0

            left = checkBalanced(node.left)
            right = checkBalanced(node.right)
            if abs(left - right) > 1:
                isBalanced = False

            return 1 + max(left, right)

        checkBalanced(root)
        return isBalanced


sol = Solution()
tree = Tree()
node = tree.array_to_tree([1,2,3,4,5])
print(sol.isBalanced(node))

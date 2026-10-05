from typing import Optional, List
from Tree import TreeNode, Tree


class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        maxLen = [0]
        def getLen(node):
            if not node:
                return 0

            left = getLen(node.left)
            right = getLen(node.right)
            maxLen[0] = max(maxLen[0], 1 + left + right)

            return 1 + max(left, right)

        getLen(root)
        return maxLen[0]-1


sol = Solution()
tree = Tree()
node = tree.array_to_tree([1,2,3,4,5])
print(sol.diameterOfBinaryTree(node))

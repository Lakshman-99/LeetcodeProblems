from typing import Optional, List
from Tree import TreeNode, Tree

class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        def inorder(node):
            if not node:
                return

            inorder(node.left)
            result.append(node.val)
            inorder(node.right)

        inorder(root)
        return result


sol = Solution()
tree = Tree()
node = tree.array_to_tree([1,2,3,4,5,None,8,None,None,6,7,9])
print(sol.inorderTraversal(node))

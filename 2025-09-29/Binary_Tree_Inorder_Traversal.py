from typing import Optional, List

from TreeNode import TreeNode
from Tree import Tree


class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        answer = []

        def dfs(root):
            if root == None:
                return

            dfs(root.left)
            answer.append(root.val)
            dfs(root.right)

            return

        dfs(root)

        return answer


sol = Solution()
tree = Tree()
node = tree.array_to_tree([1,2,3,4,5,None,8,None,None,6,7,9])
node2 = tree.array_to_tree([21, 2, 4, 7, None, 17, None, None, 8, None, 18, 10,12,None,19,14,15,None,9,21,None,None,None,None,None,11,1,None,22])
print(sol.inorderTraversal(node))
print(sol.inorderTraversal(node2))
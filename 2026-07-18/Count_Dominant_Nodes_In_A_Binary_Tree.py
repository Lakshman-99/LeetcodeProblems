from typing import Optional

from neetcode250.Binary_Tree.Tree import TreeNode, Tree


class Solution:
    def countDominantNodes(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        self.count = 0
        def dfs(node):
            if not node:
                return 0

            left = dfs(node.left)
            right = dfs(node.right)

            if node.val >= left and node.val >= right:
                self.count += 1

            return max(node.val, left, right)

        dfs(root)
        return self.count


sol = Solution()
tree = Tree()
node = tree.array_to_tree([1,2,3,1,2])
print(sol.countDominantNodes(node))
from collections import deque
from typing import Optional, List

from TreeNode import TreeNode
from Tree import Tree


class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        if not root:
            return True

        ans = [root.val]
        def dfs(root):
            if not root:
                return 0

            l = max(0, dfs(root.left))
            r = max(0, dfs(root.right))

            ans[0] = max(ans[0], root.val + l + r)
            return root.val + max(l, r)

        dfs(root)
        return ans[0]


sol = Solution()
tree = Tree()
node = tree.array_to_tree([-10,9,20,None,None,15,7])
print(sol.maxPathSum(node))

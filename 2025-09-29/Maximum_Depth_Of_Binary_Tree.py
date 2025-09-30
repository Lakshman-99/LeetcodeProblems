from collections import deque
from typing import Optional, List

from TreeNode import TreeNode
from Tree import Tree


class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        def dfs(root, curDepth):
            if not root:
                return curDepth-1

            l = dfs(root.left, curDepth+1)
            r = dfs(root.right, curDepth+1)

            return max(l, r)

        return dfs(root, 1)



sol = Solution()
tree = Tree()
node = tree.array_to_tree([3,9,20,None,None,15,7])
print(sol.maxDepth(node))

from collections import deque
from typing import Optional, List

from TreeNode import TreeNode
from Tree import Tree


class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> int:
        if not root:
            return True

        is_balanced = [True]
        def dfs(root, curDepth):
            if not root:
                return curDepth-1

            l = dfs(root.left, curDepth+1)
            r = dfs(root.right, curDepth+1)

            if is_balanced[0] and abs(l-r) > 1:
                is_balanced[0] = False

            return max(l, r)

        dfs(root, 1)
        return is_balanced[0]



sol = Solution()
tree = Tree()
node = tree.array_to_tree([1,2,2,3,None,None,3,4,None,None,4])
print(sol.isBalanced(node))

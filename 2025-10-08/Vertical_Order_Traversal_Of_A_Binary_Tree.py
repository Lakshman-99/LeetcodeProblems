from typing import Optional, List

from TreeNode import TreeNode
from Tree import Tree


class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []

        lst = []

        def dfs(root, depth, order):
            if not root:
                return

            lst.append((order, depth, root.val))
            dfs(root.left, depth + 1, order - 1)
            dfs(root.right, depth + 1, order + 1)

        dfs(root, 0, 0)

        lst.sort()
        d = {}
        for order, depth, val in lst:
            if order not in d:
                d[order] = []

            d[order].append(val)

        return list(d.values())


sol = Solution()
tree = Tree()
node = tree.array_to_tree([8, 2, 3, 4, 6, 5, 7])
print(sol.verticalTraversal(node))

from collections import deque
from typing import Optional, List

from TreeNode import TreeNode
from Tree import Tree


class Solution:
    def purge_hotel(self, root: Optional[TreeNode]):
        result = []

        def dfs(node):
            if not node:
                return -1

            lh = dfs(node.left)
            rh = dfs(node.right)

            h = 1 + max(lh, rh)
            if len(result) <= h:
                result.append([])

            result[h].append(node.val)
            return h

        dfs(root)
        return result

sol = Solution()
tree = Tree()
node = tree.array_to_tree(["👻", "😱", "🧛🏾‍♀️", "💀", "😈"])
print(sol.purge_hotel(node))

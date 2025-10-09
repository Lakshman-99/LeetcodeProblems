from typing import Optional, List

from TreeNode import TreeNode
from Tree import Tree


class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []

        ans = {}
        def dfs(root, depth, order):
            if not root:
                return

            if order not in ans:
                ans[order] = []

            ans[order].append((root.val, depth))
            dfs(root.left, depth+1, order-1)
            dfs(root.right, depth+1, order+1)

        dfs(root, 0, 0)

        srtd = sorted(ans.items(), key=lambda x: x[0])
        result = []

        for lst in srtd:
            s = sorted(lst[1], key=lambda x: (x[1], x[0]))
            result.append([value for value, _ in s])

        return result


sol = Solution()
tree = Tree()
node = tree.array_to_tree([8,2,3,4,6,5,7])
print(sol.verticalTraversal(node))

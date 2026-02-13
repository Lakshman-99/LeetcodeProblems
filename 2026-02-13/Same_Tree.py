from typing import Optional, List
from Tree import TreeNode, Tree


class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        if not p and not q:
            return True
        elif not p or not q or p.val != q.val:
            return False

        return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)


sol = Solution()
tree = Tree()
node = tree.array_to_tree([1,2,3])
node2 = tree.array_to_tree([1,2,3])
print(sol.isSameTree(node, node2))

from typing import Optional, List
from Tree import TreeNode, Tree


class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        if not p and not q:
            return True
        elif not p or not q or p.val != q.val:
            return False

        return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)

    def getLength(self, root) -> int:
        if not root:
            return 0

        return 1 + self.getLength(root.left) + self.getLength(root.right)

    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        possibleRoots = []
        subTreeHeight = self.getLength(subRoot)

        def findRoots(node):
            if not node:
                return 0

            left = findRoots(node.left)
            right = findRoots(node.right)
            length = 1 + left + right

            if length == subTreeHeight and node.val == subRoot.val:
                possibleRoots.append(node)

            return length

        findRoots(root)
        for pRoot in possibleRoots:
            if self.isSameTree(pRoot, subRoot):
                return True

        return False



sol = Solution()
tree = Tree()
node1 = tree.array_to_tree([3,4,5,1,2,None,None,None,None,0])
node2 = tree.array_to_tree([4,1,2])
print(sol.isSubtree(node1, node2))

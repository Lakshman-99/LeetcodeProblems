from collections import deque
from typing import Optional, List

from TreeNode import TreeNode
from Tree import Tree


class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []

        result = []
        reversed = False
        q = deque()
        q.append(root)
        while q:
            l = len(q)
            curList = []
            for i in range(l):
                node = q.popleft()
                curList.append(node.val)

                if node.left:
                    q.append(node.left)

                if node.right:
                    q.append(node.right)

            if reversed:
                curList.reverse()

            result.append(curList)
            reversed = not reversed

        return result

sol = Solution()
tree = Tree()
node = tree.array_to_tree([3,9,20,None,None,15,7])
print(sol.zigzagLevelOrder(node))

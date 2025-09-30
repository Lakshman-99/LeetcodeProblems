from collections import deque
from typing import Optional, List

from TreeNode import TreeNode
from Tree import Tree


class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        level = []

        q = deque()
        q.append(root)

        while q:
            curLevel = []
            for i in range(len(q)):
                node = q.popleft()
                curLevel.append(node.val)

                if node.left:
                    q.append(node.left)

                if node.right:
                    q.append(node.right)

            level.append(curLevel)

        return level



sol = Solution()
tree = Tree()
node = tree.array_to_tree([3,9,20,None,None,15,7])
print(sol.levelOrder(node))





# [[],[],[]]
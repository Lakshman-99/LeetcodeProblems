from typing import Optional, List
from Tree import TreeNode, Tree


class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        cur = root

        while cur:
            if not cur.left:
                result.append(cur.val)
                cur = cur.right
            else:
                leftPointer = cur.left
                while leftPointer.right and leftPointer.right != cur:
                    leftPointer = leftPointer.right

                if not leftPointer.right:
                    result.append(cur.val)
                    leftPointer.right = cur
                    cur = cur.left
                else:
                    leftPointer.right = None
                    cur = cur.right

        return result


sol = Solution()
tree = Tree()
node = tree.array_to_tree([1,2,3,4,5,None,8,None,None,6,7,9])
print(sol.preorderTraversal(node))

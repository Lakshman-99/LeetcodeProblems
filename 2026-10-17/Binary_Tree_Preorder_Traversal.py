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
                pre = cur.left
                while pre.right and pre.right != cur:
                    pre = pre.right

                if not pre.right:
                    result.append(cur.val)
                    pre.right = cur
                    cur = cur.left
                else:
                    pre.right = None
                    cur = cur.right

        return result


sol = Solution()
tree = Tree()
node = tree.array_to_tree([1,2,3,4,5,None,8,None,None,6,7,9])
tree.print_tree()
print(sol.preorderTraversal(node))

from typing import Optional, List
from Tree import TreeNode, Tree


class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        cur = root

        while cur:
            if not cur.right:
                result.append(cur.val)
                cur = cur.left
            else:
                pre = cur.right
                while pre.left and pre.left != cur:
                    pre = pre.left

                if not pre.left:
                    result.append(cur.val)
                    pre.left = cur
                    cur = cur.right
                else:
                    pre.left = None
                    cur = cur.left

        result.reverse()
        return result


sol = Solution()
tree = Tree()
node = tree.array_to_tree([1,2,3,4,5,None,8,None,None,6,7,9])
tree.print_tree()
print(sol.postorderTraversal(node))

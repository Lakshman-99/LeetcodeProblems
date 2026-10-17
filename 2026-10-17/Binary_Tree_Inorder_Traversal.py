from typing import Optional, List
from Tree import TreeNode, Tree

class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        curr = root

        while curr is not None:
            if curr.left is None:
                res.append(curr.val)
                curr = curr.right
            else:
                pre = curr.left
                while pre.right is not None and pre.right != curr:  # find rightmost
                    pre = pre.right

                if pre.right is None:
                    # establish a link back to the current node
                    pre.right = curr
                    curr = curr.left
                else:
                    # restore the tree structure
                    pre.right = None
                    res.append(curr.val)
                    curr = curr.right

        return res


sol = Solution()
tree = Tree()
node = tree.array_to_tree([1,None,2,3])
tree.print_tree()

print(sol.inorderTraversal(node))
tree.print_tree()

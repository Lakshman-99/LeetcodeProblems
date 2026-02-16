from collections import deque
from typing import Optional, List
from Tree import TreeNode, Tree


class Codec:

    def serialize(self, root):
        preorder = []

        def dfs(node):
            if not node:
                preorder.append("N")
                return

            preorder.append(str(node.val))
            dfs(node.left)
            dfs(node.right)

        dfs(root)
        return ",".join(preorder)

    def deserialize(self, data: str):
        vals = data.split(",")
        pre_idx = 0

        def dfs():
            nonlocal pre_idx
            if vals[pre_idx] == "N":
                pre_idx += 1
                return None

            node = TreeNode(vals[pre_idx])
            pre_idx += 1
            node.left = dfs()
            node.right = dfs()

            return node

        return dfs()


sol = Codec()
tree = Tree()
node = tree.array_to_tree([])
print(sol.serialize(node))
x = sol.serialize(node)
sol.deserialize(x)
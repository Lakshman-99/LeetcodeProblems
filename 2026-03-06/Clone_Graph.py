class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

from typing import Optional

class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        seen = {None : None}

        def dfs(root):
            if root in seen:
                return seen[root]

            clone = Node(root.val)
            seen[root] = clone

            for nei in root.neighbors:
                clone.neighbors.append(dfs(nei))

            return clone

        return dfs(node)

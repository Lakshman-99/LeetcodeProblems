from collections import deque
from typing import Optional, List

from TreeNode import TreeNode
from Tree import Tree

class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return None

        q = deque([root])
        while q:
            cur_len = len(q)
            cur_list = []
            for _ in range(cur_len):
                node = q.popleft()
                cur_list.append(node)
                if node.left:
                    q.append(node.left)

                if node.right:
                    q.append(node.right)

            for i in range(cur_len):
                if i + 1 < cur_len:
                    cur_list[i].next = cur_list[i+1]

        return root


sol = Solution()
tree = Tree()
node = tree.array_to_tree([1,2,3,4,5,None,7])
print(sol.connect(node))

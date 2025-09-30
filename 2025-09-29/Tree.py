import collections
from TreeNode import TreeNode


class Tree:
    def __init__(self, arr=None):
        if arr:
            self.root = self.array_to_tree(arr)
        else:
            self.root = None

    def array_to_tree(self, arr):
        if not arr:
            return None

        # Create the root node from the first element
        root = TreeNode(arr[0])

        # Use a queue to keep track of parent nodes
        queue = collections.deque([root])
        i = 1  # Start from the second element for the children

        while queue and i < len(arr):
            current_node = queue.popleft()

            # Process the left child
            if arr[i] is not None:
                left_child = TreeNode(arr[i])
                current_node.left = left_child
                queue.append(left_child)
            i += 1

            if i >= len(arr):
                break

            # Process the right child
            if arr[i] is not None:
                right_child = TreeNode(arr[i])
                current_node.right = right_child
                queue.append(right_child)
            i += 1

        return root

    def print_tree(self):
        if not self.root:
            print("Tree is empty.")
            return
        self._print_recursive(self.root, "", True)

    def _print_recursive(self, node, prefix, is_left):
        if not node:
            return

        # Print the right subtree first
        if node.right:
            self._print_recursive(node.right, prefix + ("│   " if is_left else "    "), False)

        # Print the current node
        print(prefix + ("└── " if is_left else "┌── ") + str(node.val))

        # Print the left subtree
        if node.left:
            self._print_recursive(node.left, prefix + ("    " if is_left else "│   "), True)

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    public static TreeNode root;
    public Tree() {
        root = null;
    }

    public TreeNode arrayToTree(Integer[] input){
        root = createTreeNode(input);
        return root;
    }

    private TreeNode createTreeNode(Integer[] input){
        if (input == null || input.length == 0 || input[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(input[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;
        while (!queue.isEmpty() && index < input.length) {
            TreeNode current = queue.poll();

            // Assign left child
            if (input[index] != null) {
                current.left = new TreeNode(input[index]);
                queue.offer(current.left);
            }
            index++;

            // Assign right child
            if (index < input.length && input[index] != null) {
                current.right = new TreeNode(input[index]);
                queue.offer(current.right);
            }
            index++;
        }

        return root;
    }

    // Function to print the tree using inorder traversal
// Function to print the tree nodes in level-order traversal
    public void printTree(TreeNode rooot) {
        if(rooot == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(rooot);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val);
            if (!queue.isEmpty())
                System.out.print(", ");

            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }
}

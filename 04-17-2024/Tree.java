import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    public static TreeNode root;
    public Tree() {
        root = null;
    }

    public TreeNode arrayToTree(Integer[] input){
        root = createTreeNode(input,0);
        return root;
    }

    private TreeNode createTreeNode(Integer[] input, int index){
        if (index >= input.length) {
            return null;
        }
        TreeNode node = null;
        if (input[index] != null) {
            node = new TreeNode(input[index]);
            node.left = createTreeNode(input, 2 * index + 1); // Left child
            node.right = createTreeNode(input, 2 * index + 2); // Right child
        }
        return node;
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

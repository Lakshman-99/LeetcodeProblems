public class Invert_Binary_Tree {
    public static TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode node = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(node);

        return root;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{4,2,7,1,3,6,9};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        TreeNode ans = invertTree(root);
        tree.printTree(ans);
    }
}

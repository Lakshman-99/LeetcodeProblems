public class Symmetric_Tree_PT {
    private static boolean solve(TreeNode r1, TreeNode r2) {
        if(r1 == null && r2 == null) return true;
        if(r1 == null || r2 == null || r1.val != r2.val) return false;

        return solve(r1.left, r2.right) && solve(r1.right, r2.left);
    }
    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;

        return solve(root.left, root.right);
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,2,3,4,4,3};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        System.out.println(isSymmetric(root));
    }
}

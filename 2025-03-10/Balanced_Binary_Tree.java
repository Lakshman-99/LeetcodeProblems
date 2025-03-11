public class Balanced_Binary_Tree {
    private static boolean ans;
    public static int solve(TreeNode root) {
        if(root == null) return 0;

        int l = solve(root.left);
        int r = solve(root.right);

        if(Math.abs(l-r) > 1)
            ans = false;

        return 1 + Math.max(l, r);
    }
    public static boolean isBalanced(TreeNode root) {
        ans = true;
        solve(root);
        return ans;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,2,3,3,null,null,4,4};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        boolean ans = isBalanced(root);
        System.out.println(ans);
    }
}

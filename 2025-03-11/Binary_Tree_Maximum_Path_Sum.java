import java.util.List;

public class Binary_Tree_Maximum_Path_Sum {
    private static int ans;
    public static int solve(TreeNode root) {
        if(root == null) return 0;

        int l = Math.max(0, solve(root.left));
        int r = Math.max(0, solve(root.right));

        ans = Math.max(ans, root.val+l+r);

        return root.val + Math.max(l, r);
    }
    public static int maxPathSum(TreeNode root) {
        ans = root.val;
        solve(root);
        return ans;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,-2,3};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        int ans = maxPathSum(root);
        System.out.println(ans);
    }
}

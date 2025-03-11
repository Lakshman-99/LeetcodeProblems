import java.util.ArrayList;

public class Diameter_Of_Binary_Tree {
    private static int ans;
    public static int solve(TreeNode root) {
        if(root == null) return 0;

        int l = solve(root.left);
        int r = solve(root.right);

        ans = Math.max(ans, l + r);

        return 1 + Math.max(l, r);
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        solve(root);
        return ans;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,1,null,null,2};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        int ans = diameterOfBinaryTree(root);
        System.out.println(ans);
    }
}

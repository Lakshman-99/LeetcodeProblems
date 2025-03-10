import java.util.ArrayList;
import java.util.Stack;

public class Max_Depth_Of_BT {
    private static int ans;
    public static void solve(TreeNode root, int depth) {
        if(root == null) return;

        ans = Math.max(ans, depth);
        solve(root.left, depth + 1);
        solve(root.right, depth + 1);
    }
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;

        ans = 0;
        solve(root, 0);
        return ans + 1;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,9,20};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        int ans = maxDepth(root);
        System.out.println(ans);
    }
}

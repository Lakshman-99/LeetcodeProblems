import java.util.ArrayList;
import java.util.List;

public class Postorder_Traversal {
    private static List<Integer> ans;

    public static void solve(TreeNode root) {
        if(root == null) return;

        solve(root.left);
        solve(root.right);
        ans.add(root.val);
    }
    public static List<Integer> postorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        solve(root);
        return ans;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4,5,null,8,null,null,6,7,9};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        List<Integer> ans = postorderTraversal(root);
        System.out.println(ans.toString());
    }
}

import java.util.ArrayList;
import java.util.List;

public class Left_View_Of_Binary_Tree {
    private static List<Integer> ans;

    public static void solve(TreeNode root, int level) {
        if(root == null) return;
        if(level == ans.size()) ans.add(root.val);

        solve(root.left, level+1);
        solve(root.right, level+1);
    }
    public static List<Integer> leftView(TreeNode root) {
        ans = new ArrayList<>();
        solve(root, 0);
        return ans;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, null, null, 4, null, null, 5, null, null};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        List<Integer> ans = leftView(root);
        System.out.println(ans.toString());
    }
}

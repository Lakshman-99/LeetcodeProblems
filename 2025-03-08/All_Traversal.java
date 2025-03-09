import java.util.ArrayList;
import java.util.List;

public class All_Traversal {
    private static List<List<Integer>> ans;

    public static void solve(TreeNode root) {
        if(root == null) return;

        ans.get(1).add(root.val);
        solve(root.left);
        ans.get(0).add(root.val);
        solve(root.right);
        ans.get(2).add(root.val);
    }
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        solve(root);
        return ans;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4,5,null,8,null,null,6,7,9};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        List<List<Integer>> ans = getTreeTraversal(root);
        System.out.println(ans.toString());
    }
}

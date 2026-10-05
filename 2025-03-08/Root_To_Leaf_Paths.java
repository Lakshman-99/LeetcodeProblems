import java.util.*;

public class Root_To_Leaf_Paths {
    private static ArrayList<ArrayList<Integer>> ans;
    public static void solve(TreeNode root, Stack<Integer> curPath) {
        if(root == null) return;

        if(root.left == null && root.right == null) {
            curPath.add(root.val);
            ans.add(new ArrayList<>(curPath));
            curPath.pop();
            return;
        }

        curPath.add(root.val);
        solve(root.left, curPath);
        solve(root.right, curPath);
        curPath.pop();
    }
    public static ArrayList<ArrayList<Integer>> Paths(TreeNode root) {
        ans = new ArrayList<>();
        solve(root, new Stack<>());
        return ans;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{6, null, 4, 8, 5, 10, 3, 9, 11, 2, 7, 1};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        ArrayList<ArrayList<Integer>> ans = Paths(root);
        System.out.println(ans.toString());
    }
}

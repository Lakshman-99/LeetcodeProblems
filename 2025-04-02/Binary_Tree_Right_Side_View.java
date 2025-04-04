package amazon;

import java.util.*;

public class Binary_Tree_Right_Side_View {

    public static void solve(TreeNode root, int depth, List<Integer> ans) {
        if(root == null) return;

        if(depth == ans.size()) {
            ans.add(root.val);
        }

        solve(root.right, depth+1, ans);
        solve(root.left, depth+1, ans);
    }
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        solve(root, 0, ans);

        return ans;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,null,5,null,4};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        System.out.println(rightSideView(root));
    }
}

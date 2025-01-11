//  145. Binary Tree Postorder Traversal
//
//  https://leetcode.com/problems/binary-tree-postorder-traversal/
import java.util.*;

public class Binary_Tree_Postorder_Traversal {
    public static List<Integer> ans;
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
        Integer[] arr = new Integer[]{1,2,3,4,5,6,7};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        List<Integer> ans = postorderTraversal(root);
        System.out.println(ans.toString());
    }
}

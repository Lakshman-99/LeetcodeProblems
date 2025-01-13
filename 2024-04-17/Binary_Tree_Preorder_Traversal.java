//  144. Binary Tree Preorder Traversal
//
//  https://leetcode.com/problems/binary-tree-preorder-traversal/

import java.util.*;

public class Binary_Tree_Preorder_Traversal {
    public static List<Integer> ans;
    public static void solve(TreeNode root) {
        if(root == null) return;
        ans.add(root.val);
        solve(root.left);
        solve(root.right);
    }
    public static List<Integer> preorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        solve(root);
        return ans;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4,5,6,7};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        List<Integer> ans = preorderTraversal(root);
        System.out.println(ans.toString());
    }
}

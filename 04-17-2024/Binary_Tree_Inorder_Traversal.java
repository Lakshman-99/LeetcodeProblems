//  94. Binary Tree Inorder Traversal
//
//  https://leetcode.com/problems/binary-tree-inorder-traversal/description/

import java.util.*;

public class Binary_Tree_Inorder_Traversal {
    public static List<Integer> ans;
    public static void solve(TreeNode root) {
        if(root == null) return;
        solve(root.left);
        ans.add(root.val);
        solve(root.right);
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        solve(root);
        return ans;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4,5,6,7};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        List<Integer> ans = inorderTraversal(root);
        System.out.println(ans.toString());
    }
}

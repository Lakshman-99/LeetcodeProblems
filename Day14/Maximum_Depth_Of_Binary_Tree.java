//  104. Maximum Depth of Binary Tree
//
//  https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

public class Maximum_Depth_Of_Binary_Tree {
    public static int ans;
    public static void solve(TreeNode root, int sum) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            ans = Math.max(ans, sum);
            return;
        }
        solve(root.left, sum+1);
        solve(root.right, sum+1);
    }
    public static int maxDepth(TreeNode root) {
        ans = 0;
        solve(root, 1);
        return ans;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,null,2};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        int ans = maxDepth(root);
        System.out.println(ans);
    }
}

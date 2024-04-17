//  111. Minimum Depth of Binary Tree
//
//  https://leetcode.com/problems/minimum-depth-of-binary-tree/

public class Minimum_Depth_Of_Binary_Tree {
    public static int ans;
    public static void solve(TreeNode root, int sum) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            ans = Math.min(ans, sum);
            return;
        }
        solve(root.left, sum+1);
        solve(root.right, sum+1);
    }
    public static int minDepth(TreeNode root) {
        ans = root == null ? 0 :99999;
        solve(root, 1);
        return ans;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,9,20,null,null,15,7};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        int ans = minDepth(root);
        System.out.println(ans);
    }
}

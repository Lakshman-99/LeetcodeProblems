//  112. Path Sum
//
//  https://leetcode.com/problems/path-sum/description/

public class Path_Sum {
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null && targetSum - root.val == 0) return true;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        System.out.println(hasPathSum(root, 4));
    }
}

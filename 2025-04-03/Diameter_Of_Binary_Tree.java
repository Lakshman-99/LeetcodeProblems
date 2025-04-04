package amazon;

public class Diameter_Of_Binary_Tree {
    public static int ans;
    public static int solve(TreeNode root) {
        if(root == null) return 0;

        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);

        ans = Math.max(ans, left + right);

        return 1 + Math.max(left, right);
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        solve(root);
        return ans;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,1,null,null,2};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        int ans = diameterOfBinaryTree(root);
        System.out.println(ans);
    }
}

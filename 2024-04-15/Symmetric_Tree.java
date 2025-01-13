//  101. Symmetric Tree
//
//  https://leetcode.com/problems/symmetric-tree/description/

public class Symmetric_Tree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
    }
    public static boolean isSymmetric(TreeNode root) {
        return isSameTree(root.left, root.right);
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2,3,3,4,5,5};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        System.out.println(isSymmetric(root));
    }
}

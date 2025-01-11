//  100. Same Tree
//
//  https://leetcode.com/problems/same-tree/description/

public class Same_Tree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        if(p.left == null && p.right == null && q.left == null && q.right == null) return true;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    public static void main(String[] args) {
        Integer[] arr1 = new Integer[]{1,null,2};
        Integer[] arr2 = new Integer[]{1,null,2};

        Tree tree1 = new Tree();
        TreeNode root1 = tree1.arrayToTree(arr1);

        Tree tree2 = new Tree();
        TreeNode root2 = tree2.arrayToTree(arr2);

        System.out.println(isSameTree(root1, root2));
    }
}

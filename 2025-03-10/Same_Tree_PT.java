public class Same_Tree_PT {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null || p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,2,3,3,null,null,4,4};
        Integer[] arr1 = new Integer[]{1,2,2,3,3,null,null,4,3};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        Tree tree1 = new Tree();
        TreeNode root1 = tree1.arrayToTree(arr1);
        boolean ans = isSameTree(root, root1);
        System.out.println(ans);
    }
}

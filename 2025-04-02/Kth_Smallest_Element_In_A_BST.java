package amazon;

public class Kth_Smallest_Element_In_A_BST {
    static int count;
    public static TreeNode helper(TreeNode root, int k) {
        if(root == null) return null;

        TreeNode left = helper(root.left, k);
        if(left != null)
            return left;

        count++;
        if(count == k)
            return root;

        return helper(root.right, k);
    }
    public static int kthSmallest(TreeNode root, int k) {
        count = 0;
        TreeNode node = helper(root, k);
        return node == null ? 0 : node.val;
    }
    public static void main(String[] args) {
        Integer[] arr = {5,3,6,2,4,null,null,1};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        System.out.println(kthSmallest(root, 3));
    }
}

public class Construct_Binary_Tree_From_Inorder_And_Postorder_Traversal {
    private static int str;
    public static TreeNode solve(int[] postorder, int[] inorder, int ii, int ij) {
        if(ii >= ij || str < 0) return null;

        TreeNode root = new TreeNode(postorder[str]);

        int i = ii;
        while(postorder[str] != inorder[i]) i++;
        str--;

        root.right = solve(postorder, inorder, i+1, ij);
        root.left = solve(postorder, inorder, ii, i);

        return root;
    }
    public static TreeNode buildTree(int[] postorder, int[] inorder) {
        str = postorder.length-1;
        return solve(postorder, inorder, 0, inorder.length-1);
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,9,20,null,null,15,7};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        TreeNode ans = buildTree(new int[]{9,15,7,20,3}, new int[]{9,3,15,20,7});
        tree.printTree(ans);
    }
}

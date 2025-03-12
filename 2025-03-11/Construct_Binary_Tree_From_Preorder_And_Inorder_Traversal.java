import java.util.List;

public class Construct_Binary_Tree_From_Preorder_And_Inorder_Traversal {
    private static int str;
    public static TreeNode solve(int[] preorder, int[] inorder, int ii, int ij) {
        if(ii >= ij || str == preorder.length) return null;

        TreeNode root = new TreeNode(preorder[str]);

        int i=ii;
        while(preorder[str] != inorder[i] && i < ij) i++;
        str++;

        root.left = solve(preorder, inorder, ii, i);
        root.right = solve(preorder, inorder, i+1, ij);

        return root;
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        str = 0;
        return solve(preorder, inorder, 0, inorder.length);
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,9,20,null,null,15,7};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        TreeNode ans = buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        tree.printTree(ans);
    }
}

import java.util.ArrayList;

public class Maximum_Width_Of_Binary_Tree {
    public static int widthOfBinaryTree(TreeNode root) {
        
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{6, null, 4, 8, 5, 10, 3, 9, 11, 2, 7, 1};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        int ans = widthOfBinaryTree(root);
        System.out.println(ans);
    }
}

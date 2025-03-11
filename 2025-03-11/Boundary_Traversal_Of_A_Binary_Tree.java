import java.util.ArrayList;
import java.util.List;

public class Boundary_Traversal_Of_A_Binary_Tree {
    private static List<Integer> ans;
    public static void addLeftBoundary(TreeNode root) {
        if(root ==null) return;

        if(root.left != null || root.right != null)
            ans.add(root.val);

        addLeftBoundary(root.left);
        if(root.left == null)
            addLeftBoundary(root.right);
    }

    public static  void addRightBoundary(TreeNode root) {
        if(root ==null) return;

        addRightBoundary(root.right);
        if(root.right == null)
            addRightBoundary(root.left);

        if(root.left != null || root.right != null)
            ans.add(root.val);
    }

    public static void addBottomBoundary(TreeNode root) {
        if(root == null) return;

        if(root.left == null && root.right == null)
            ans.add(root.val);

        addBottomBoundary(root.left);
        addBottomBoundary(root.right);
    }
    public static List<Integer> boundaryTraversal(TreeNode root) {
        ans = new ArrayList<>();

        addLeftBoundary(root);
        addBottomBoundary(root);
        addRightBoundary(root.right);

        return ans;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{10, 5, 20, 3, 8, 18, 25, null, 7, null, null};
//        Integer[] arr = new Integer[]{1, 2, 7, 3, null, null, 8, null, 4, 9, null, 5, 6, 10, 11};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        List<Integer> ans = boundaryTraversal(root);
        System.out.println(ans.toString());
    }
}

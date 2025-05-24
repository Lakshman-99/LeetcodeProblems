import java.util.HashMap;
import java.util.HashSet;

public class Step_By_Step_Directions_From_A_Binary_Tree_Node_To_Another {
    public static boolean findDirections(TreeNode n, int val, StringBuilder sb) {
        if (n.val == val)
            return true;
        if (n.left != null && findDirections(n.left, val, sb))
            sb.append("L");
        else if (n.right != null && findDirections(n.right, val, sb))
            sb.append("R");
        return !sb.isEmpty();
    }
    public static TreeNode getLca(TreeNode root, int sv, int dv) {
        if(root == null || root.val == sv || root.val == dv) return root;
        TreeNode left = getLca(root.left, sv, dv);
        TreeNode right = getLca(root.right, sv, dv);

        return left == null ? right : right == null ? left : root;
    }
    public static String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();

        TreeNode lca = getLca(root, startValue, destValue);

        findDirections(lca, startValue, left);
        findDirections(lca, destValue, right);


        return "U".repeat(left.length()) + right.reverse();
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5,1,2,3,null,6,4};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        System.out.println(getDirections(root, 3, 6));
    }
}

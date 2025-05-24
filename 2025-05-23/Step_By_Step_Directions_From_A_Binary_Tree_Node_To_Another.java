import java.util.HashMap;
import java.util.HashSet;

public class Step_By_Step_Directions_From_A_Binary_Tree_Node_To_Another {
    public static String answer;
    public static TreeNode getStart(TreeNode root, int sv) {
        if(root == null) return null;

        if(root.val == sv) return root;

        TreeNode left = getStart(root.left, sv);
        if(left != null) return left;

        return getStart(root.right, sv);
    }
    public static void constructParents(TreeNode root, TreeNode parent, HashMap<TreeNode, TreeNode> parents) {
        if(root == null) return;

        parents.put(root, parent);
        constructParents(root.left, root, parents);
        constructParents(root.right, root, parents);
    }
    public static void helper(TreeNode root, HashMap<TreeNode, TreeNode> parents, int dv, String direction, HashSet<TreeNode> visited) {
        if(root == null || visited.contains(root)) return;

        if(root.val == dv) {
            answer = direction;
            return;
        }

        visited.add(root);
        helper(root.left, parents, dv, direction + "L", visited);
        helper(root.right, parents, dv, direction + "R", visited);
        helper(parents.get(root), parents, dv, direction + "U", visited);
    }
    public static String getDirections(TreeNode root, int startValue, int destValue) {
        if(root == null) return "";

        TreeNode startNode = getStart(root, startValue);
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        constructParents(root, null, parents);

        answer = "";
        helper(startNode, parents, destValue, "", new HashSet<TreeNode>());

        return answer;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5,1,2,3,null,6,4};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        System.out.println(getDirections(root, 3, 6));
    }
}

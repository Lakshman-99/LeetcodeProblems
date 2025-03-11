import java.util.List;

public class Lowest_Common_Ancestor_Of_A_Binary_Tree {
    public static TreeNode ans;
    public static boolean solve(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return false;

        boolean l = solve(root.left, p, q);
        boolean r = solve(root.right, p, q);

        if(l && r || (root.val == p.val && (l || r)) || (root.val == q.val && (l || r)))
            ans = root;

        if(root.val == p.val || root.val == q.val)
            return true;

        return l || r;
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = null;
        solve(root, p, q);
        return ans;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        TreeNode ans = lowestCommonAncestor(root, new TreeNode(1), new TreeNode(2));
        System.out.println(ans);
    }
}

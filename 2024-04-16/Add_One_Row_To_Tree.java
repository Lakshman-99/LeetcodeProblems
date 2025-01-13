//  623. Add One Row to Tree
//
//  https://leetcode.com/problems/add-one-row-to-tree/description/

public class Add_One_Row_To_Tree {
    public static void solve(TreeNode root, int val, int depth) {
        if(root == null) return;
        if(depth - 1 == 1) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = new TreeNode(val, left, null);
            root.right = new TreeNode(val, null, right);
        }
        addOneRow(root.left, val, depth-1);
        addOneRow(root.right, val, depth-1);
    }
    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            node.right = null;
            return node;
        }
        solve(root, val, depth);
        return root;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{4,2,6,3,1,5};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        TreeNode ans = addOneRow(root, 1, 1);
        tree.printTree(ans);
    }
}

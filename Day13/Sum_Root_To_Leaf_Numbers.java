//  129. Sum Root to Leaf Numbers
//
//  https://leetcode.com/problems/sum-root-to-leaf-numbers/description/

public class Sum_Root_To_Leaf_Numbers {
    public static int ans;

    public static void add(TreeNode root, int sum) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            ans += sum;
            return;
        }
        if(root.left != null) add(root.left, sum*10 + root.left.val);
        if(root.right != null) add(root.right, sum*10 + root.right.val);
    }
    public static int sumNumbers(TreeNode root) {
        ans = root.val;
        add(root, ans);
        return ans - root.val;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{4,9,0,5,1};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        int result = sumNumbers(root);
        System.out.println(result);
    }
}

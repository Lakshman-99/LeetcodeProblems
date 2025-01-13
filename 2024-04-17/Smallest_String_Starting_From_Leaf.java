//  988. Smallest String Starting From Leaf
//
//  https://leetcode.com/problems/smallest-string-starting-from-leaf/description/

public class Smallest_String_Starting_From_Leaf {
    public static String ans;
    public static void solve(TreeNode root, StringBuilder sb) {
        if(root == null) return;
        sb.append((char)(root.val + 'a'));

        if(root.left == null && root.right == null) {
            String str = sb.reverse().toString();
            sb.reverse();
            if(ans == null || ans.compareTo(str) > 0) ans = str;
        }
        solve(root.left, sb);
        solve(root.right, sb);
        sb.setLength(sb.length()-1);
    }
    public static String smallestFromLeaf(TreeNode root) {
        ans = null;
        solve(root, new StringBuilder());
        return ans;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{25,1,3,1,3,0,2};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        String ans = smallestFromLeaf(root);
        System.out.println(ans);
    }
}

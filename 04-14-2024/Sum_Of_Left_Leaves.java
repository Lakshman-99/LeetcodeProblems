//  404. Sum of Left Leaves
//
//  https://leetcode.com/problems/sum-of-left-leaves/description/

public class Sum_Of_Left_Leaves {
    public static int ans=0;
    public static int sumOfLeftLeaves(TreeNode root) {
        sum(root);
        return ans;
    }

    public static void sum(TreeNode root)
    {
        if(root==null) return;
        if(root.left!=null && root.left.left==null && root.left.right==null)
        {
            ans += root.left.val;
        }
        sum(root.left);
        sum(root.right);
    }
}

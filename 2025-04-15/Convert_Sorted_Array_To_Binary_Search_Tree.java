public class Convert_Sorted_Array_To_Binary_Search_Tree {
    public static TreeNode solve(int[] nums, int left, int right) {
        if(left > right) return null;

        int mid = left + (right-left)/2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = solve(nums, left, mid-1);
        node.right = solve(nums, mid+1, right);

        return node;
    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        return solve(nums, 0, nums.length-1);
    }
    public static void main(String[] args) {
        int[] arr = {-10,-3,0,5,9};
        Tree tree = new Tree();
        tree.printTree(sortedArrayToBST(arr));
    }
}

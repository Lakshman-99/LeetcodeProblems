import java.util.List;

public class Count_Complete_Tree_Nodes {
    public static int getHeight(TreeNode root, boolean isLeft) {
        int h = 0;
        while(root != null) {
            root = isLeft ? root.left : root.right;
            h++;
        }

        return h;
    }
    public static int countNodes(TreeNode root) {
        if(root == null) return 0;

        int leftHeight = getHeight(root, true);
        int rightHeight = getHeight(root, false);

        if(leftHeight == rightHeight)
            return (1 << leftHeight) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4,5,6};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        System.out.println(countNodes(root));
    }
}

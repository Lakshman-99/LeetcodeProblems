import java.util.List;

public class Flatten_Binary_Tree_To_Linked_List {
    public static TreeNode pre = null;
    public static void flatten(TreeNode root) {
        if(root == null) return;

        flatten(root.right);
        flatten(root.left);

        root.right = pre;
        root.left = null;
        pre = root;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,5,3,4,null,6};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        tree.printTree(root);
        System.out.println();
        flatten(root);
        tree.printTree(root);
    }
}

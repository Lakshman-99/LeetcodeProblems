package patterns.two_pointers;

import amazon.Tree;
import amazon.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class Two_Sum_IV___Input_Is_A_BST {
    public static boolean helper(TreeNode root, int k, Set<Integer> set) {
        if(root == null) return false;

        if(!set.isEmpty() && set.contains(k - root.val))
            return true;

        set.add(root.val);

        return helper(root.left, k, set) || helper(root.right, k, set);
    }
    public static boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return helper(root, k, set);
    }
    public static void main(String[] args) {
        Tree tree = new Tree();
        Integer[] arr = {5,3,6,2,4,null,7};
        TreeNode root = tree.arrayToTree(arr);
        System.out.println(findTarget(root, 9));
    }
}

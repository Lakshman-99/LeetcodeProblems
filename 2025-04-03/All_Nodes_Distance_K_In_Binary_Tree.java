package amazon;

import java.util.*;

public class All_Nodes_Distance_K_In_Binary_Tree {
    public static void getNodes(TreeNode root, int k, int c, List<Integer> ans, HashMap<TreeNode, TreeNode> parents, HashSet<TreeNode> visited) {
        if(root == null || visited.contains(root)) return;

        if(c == k) {
            ans.add(root.val);
            return;
        }

        visited.add(root);
        getNodes(root.left, k, c+1, ans, parents, visited);
        getNodes(root.right, k, c+1, ans, parents, visited);
        getNodes(parents.get(root), k, c+1, ans, parents, visited);
    }
    public static void getParents(TreeNode root, TreeNode parent, HashMap<TreeNode, TreeNode> parents) {
        if(root == null) return;

        parents.put(root, parent);

        getParents(root.left, root, parents);
        getParents(root.right, root, parents);
    }
    public static TreeNode findNode(TreeNode root, TreeNode target) {
        if(root == null) return null;

        if(root.val == target.val) return root;

        TreeNode left = findNode(root.left, target);
        if(left != null) return left;

        return findNode(root.right, target);
    }
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        HashSet<TreeNode> visted = new HashSet<>();

        getParents(root, null, parents);
        TreeNode node = findNode(root, target);
        getNodes(node, k, 0, ans, parents, visted);

        return ans;
    }
    public static void main(String[] args) {
        Integer[] arr = {3,5,1,6,2,0,8,null,null,7,4};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        System.out.println(distanceK(root, new TreeNode(5), 2));
    }
}

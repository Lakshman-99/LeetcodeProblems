package amazon;

import java.util.*;

public class Binary_Tree_Zigzag_Level_Order_Traversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean isEven = false;

        while(!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> cur = new ArrayList<>();
            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                cur.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            if(isEven)
                Collections.reverse(cur);

            isEven = !isEven;
            result.add(cur);
        }

        return result;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4,null,null,5};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        System.out.println(zigzagLevelOrder(root));
    }
}

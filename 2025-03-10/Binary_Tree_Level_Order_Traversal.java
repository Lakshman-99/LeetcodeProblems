import java.util.*;

public class Binary_Tree_Level_Order_Traversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> cur = new ArrayList<>();

            for(int i=0;i<size;i++) {
                TreeNode node = q.poll();
                cur.add(node.val);

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            ans.add(cur);
        }
        return ans;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,9,20,null,null,15,7};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        List<List<Integer>> ans = levelOrder(root);
        System.out.println(ans.toString());
    }
}

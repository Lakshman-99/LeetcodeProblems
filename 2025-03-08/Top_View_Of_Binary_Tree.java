import java.util.*;

public class Top_View_Of_Binary_Tree {
    public static ArrayList<Integer> topView(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Object[]> q = new LinkedList<>();
        q.offer(new Object[]{root, 0});

        while(!q.isEmpty()) {
            Object[] obj = q.poll();
            TreeNode node = (TreeNode) obj[0];
            int level = (int) obj[1];

            if(!map.containsKey(level)) {
                map.put(level, node.val);
            }

            if(node.left != null)
                q.offer(new Object[]{node.left, level-1});

            if(node.right != null)
                q.offer(new Object[]{node.right, level+1});

        }

        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, null, null, 4, null, null, 5, null, null};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        List<Integer> ans = topView(root);
        System.out.println(ans.toString());
    }
}

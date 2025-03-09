import java.util.*;

public class Bottom_View_Of_Binary_Tree {
    public static ArrayList<Integer> bottomView(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Queue<Object[]> q = new LinkedList<>();
        q.offer(new Object[]{root, 0});

        Map<Integer, TreeNode> map = new TreeMap<>();

        while(!q.isEmpty()) {
            Object[] obj = q.poll();

            TreeNode node = (TreeNode) obj[0];
            int level = (int) obj[1];

            map.put(level, node);

            if(node.left != null) {
                q.offer(new Object[]{node.left, level-1});
            }
            if(node.right != null) {
                q.offer(new Object[]{node.right, level+1});
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for(Integer entry : map.keySet()) {
            ans.add(map.get(entry).val);
        }

        return ans;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, null, null, 4, null, null, 5, null, null};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        List<Integer> ans = bottomView(root);
        System.out.println(ans.toString());
    }
}

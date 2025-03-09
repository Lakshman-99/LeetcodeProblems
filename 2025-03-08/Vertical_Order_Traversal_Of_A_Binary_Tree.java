import java.util.*;

public class Vertical_Order_Traversal_Of_A_Binary_Tree {
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Map<Integer, ArrayList<int[]>> map = new TreeMap<>();
        Queue<Object[]> q = new LinkedList<>();
        q.offer(new Object[]{root, 0});

        while(!q.isEmpty()) {
            Object[] obj = q.poll();
            TreeNode node = (TreeNode) obj[0];
            int level = (int) obj[1];

            map.computeIfAbsent(level, A -> new ArrayList<>()).add(new int[]{node.val, level});

            if(node.left != null)
                q.offer(new Object[]{node.left, level-1});

            if(node.right != null)
                q.offer(new Object[]{node.right, level+1});
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(ArrayList<int[]> arr : map.values()) {
            arr.sort((a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
            ans.add(arr.stream().map(k -> k[0]).toList());
        }

        return ans;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,1,4,0,2,2};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        List<List<Integer>> ans = verticalTraversal(root);
        System.out.println(ans.toString());
    }
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Maximum_Width_Of_Binary_Tree {
    public static int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        Queue<Object[]> q = new LinkedList<>();
        q.offer(new Object[]{root, 0});

        int ans = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            int str = (int) q.peek()[1];
            int idx = 0;

            for(int i=0;i<size;i++) {
                Object[] obj = q.poll();
                TreeNode node = (TreeNode) obj[0];
                idx = (int) obj[1];

                if(node.left != null) q.offer(new Object[]{node.left, 2*idx});
                if(node.right != null) q.offer(new Object[]{node.right, 2*idx+1});

            }
            ans = Math.max(ans, idx-str+1);
        }

        return ans;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{6, null, 4, 8, 5, 10, 3, 9, 11, 2, 7, 1};
        Tree tree = new Tree();
        TreeNode root = tree.arrayToTree(arr);
        int ans = widthOfBinaryTree(root);
        System.out.println(ans);
    }
}

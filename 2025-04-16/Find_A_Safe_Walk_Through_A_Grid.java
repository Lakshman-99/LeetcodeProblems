import java.util.*;

public class Find_A_Safe_Walk_Through_A_Grid {
    public static boolean solve(int m, int n, List<List<Integer>> grid, int health, int[][][] dp) {
        if(m==0 && n==0) {
            return health > grid.get(0).get(0);
        }

        if(m<0 || n<0 || m>=grid.size() || n>=grid.get(0).size() || health==0 || grid.get(m).get(n)==-1) return false;

        if(dp[m][n][health] != -1) {
            return dp[m][n][health] == 2;
        }

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        int value = grid.get(m).get(n);
        grid.get(m).set(n, -1);

        boolean answer = false;
        for(int[] dir : dirs) {
            answer = answer || solve(dir[0] + m, dir[1] + n, grid, health - value, dp);
        }

        grid.get(m).set(n, value);
        dp[m][n][health] = answer ? 2 : 1;

        return answer;
    }
    public static boolean dfs(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][][] dp = new int[m][n][health+1];
        for(int[][] row : dp)
            for(int[] col : row)
                Arrays.fill(col, -1);

        return solve(m-1, n-1, grid, health, dp);
    }
    public static boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size()-1;
        int n = grid.get(0).size()-1;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        boolean[][] visited = new boolean[m+1][n+1];
        Deque<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0, health - grid.get(0).get(0)});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];
            int curHealth = node[2];

            if(curHealth == 0)
                continue;

            if(row == m && col == n && curHealth > 0)
                return true;

            for(int[] dir : dirs) {
                int x = row+dir[0];
                int y = col+dir[1];

                if(x<0 || y<0 || x>m || y>n || visited[x][y])
                    continue;

                visited[x][y] = true;
                if(grid.get(x).get(y) == 1)
                    queue.offerLast(new int[]{x,y,curHealth-1});
                else
                    queue.offerFirst(new int[]{x,y,curHealth});
            }
        }

        return false;
    }
    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>();

        grid.add(Arrays.asList(1,1,1));
        grid.add(Arrays.asList(1,0,1));
        grid.add(Arrays.asList(1,1,1));

        System.out.println(findSafeWalk(grid, 5));
    }
}

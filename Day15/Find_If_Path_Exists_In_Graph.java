//  1971. Find if Path Exists in Graph
//
//  https://leetcode.com/problems/find-if-path-exists-in-graph/description

public class Find_If_Path_Exists_In_Graph {
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        if (edges.length == 0)
            return true;
        boolean[] visited = new boolean[n];
        boolean flag = true;
        visited[source] = true;
        while (flag) {
            flag = false;
            for (int[] edge : edges) {
                if (visited[edge[0]] != visited[edge[1]]) {
                    visited[edge[0]] = true;
                    visited[edge[1]] = true;
                    flag = true;
                }
                if (visited[destination])
                    return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] mat = new int[][]{{0,1},{1,2},{2,0}};
        boolean ans = validPath(3, mat, 0, 2);
        System.out.println(ans);
    }
}

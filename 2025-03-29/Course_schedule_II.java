package amazon;

import java.util.*;

public class Course_schedule_II {
    public static boolean dfs(ArrayList<Integer>[] adj, int[] visited, int cur, Stack<Integer> topo) {
        if(visited[cur] == 1) return false;
        if(visited[cur] == 2) return true;

        visited[cur] = 1;
        for(int num : adj[cur]) {
            if(!dfs(adj, visited, num, topo)) return false;
        }
        visited[cur] = 2;
        topo.add(cur);

        return true;
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            adj[i] = new ArrayList<>();

        for(int[] mat : prerequisites) {
            int c1 = mat[0];
            int c2 = mat[1];
            adj[c1].add(c2);
        }

        int[] visited = new int[numCourses];
        Stack<Integer> topo_order = new Stack<>();

        for(int i=0;i<numCourses;i++) {
            if(visited[i] == 0) {
                if(!dfs(adj, visited, i, topo_order)) {
                    return new int[]{};
                }
            }
        }

        for(int i=numCourses-1;i>=0;i--) {
            visited[i] = topo_order.pop();
        }

        return visited;
    }

    public static int[] findOrderBfs(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            adj[i] = new ArrayList<>();

        for(int[] mat : prerequisites) {
            int c1 = mat[0];
            int c2 = mat[1];
            adj[c2].add(c1);
        }

        int[] inDegree = new int[numCourses];
        int[] topo = new int[numCourses];
        int topoIdx = 0;
        for(int i=0;i<numCourses;i++) {
            for(int num : adj[i]) {
                inDegree[num]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++) {
            if(inDegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()) {
            int node = q.poll();
            topo[topoIdx++] = node;

            for(int num : adj[node]) {
                inDegree[num]--;
                if(inDegree[num] == 0) q.add(num);
            }
        }
        return topoIdx == numCourses ? topo : new int[]{};
    }

    public static void main(String[] args) {
        int[][] arr = {};
        System.out.println(Arrays.toString(findOrderBfs(2, arr)));
    }
}

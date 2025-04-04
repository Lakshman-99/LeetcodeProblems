package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Course_Schedule {
    public static boolean dfs(List<Integer>[] adj, int[] visited, int cur) {
        if(visited[cur] == 1) return false;
        if(visited[cur] == 2) return true;

        visited[cur] = 1;
        for(int num : adj[cur]) {
            if(!dfs(adj, visited, num)) return false;
        }
        visited[cur] = 2;
        return true;
}
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] arr : prerequisites) {
            int c1 = arr[0];
            int c2 = arr[1];

            adj[c1].add(c2);
        }

        int[] visited = new int[numCourses];
        for(int i=0;i<numCourses;i++) {
            if(visited[i] == 0 && !dfs(adj, visited, i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] arr = {{1,0}};
        System.out.println(canFinish(2, arr));
    }
}

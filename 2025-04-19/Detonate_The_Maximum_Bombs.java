import java.util.*;

public class Detonate_The_Maximum_Bombs {
    public static int dfs(int source, ArrayList<Integer>[] adj, boolean[] visited) {
        if(visited[source]) return 0;
        visited[source] = true;

        int ans = 1;
        for(int neighbor : adj[source])
            ans += dfs(neighbor, adj, visited);

        return ans;
    }
    public static int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++)
            adj[i] = new ArrayList<>();

        for(int i=0;i<n;i++) {
            int xi = bombs[i][0];
            int yi = bombs[i][1];
            int ri = bombs[i][2];
            for(int j=i+1;j<n;j++) {
                int xj = bombs[j][0];
                int yj = bombs[j][1];
                int rj = bombs[j][2];

                double d = Math.pow(xi - xj, 2) + Math.pow(yi - yj, 2);

                if(d <= Math.pow(ri, 2))
                    adj[i].add(j);

                if(d <= Math.pow(rj, 2))
                    adj[j].add(i);
            }
        }

        int ans = 0;
        for(int i=0;i<n;i++)
            ans = Math.max(ans, dfs(i, adj, new boolean[n]));

        return ans;
    }
    public static void main(String[] args) {
        int[][] bombs = {
                {1,1,100000},
                {100000,100000,1}
        };
        System.out.println(maximumDetonation(bombs));
    }
}

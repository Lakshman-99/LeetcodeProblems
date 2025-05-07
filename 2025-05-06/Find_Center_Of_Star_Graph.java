public class Find_Center_Of_Star_Graph {
    public static int findCenter(int[][] edges) {
        int n = edges.length;
        int[] adj = new int[n+2];

        for(int[] edge : edges) {
            adj[edge[0]]++;
            adj[edge[1]]++;
        }

        for(int i=1;i<=n+1;i++)
            if(adj[i] == n)
                return i;

        return -1;
    }
    public static void main(String[] args) {
        int[][] edges = {{1,2},{2,3},{4,2}};
        System.out.println(findCenter(edges));
    }
}

package patterns.graphs;

public class Find_The_Town_Judge {
    public static int findJudge(int n, int[][] trust) {
        int[] people = new int[n+1];

        for(int[] t : trust) {
            people[t[0]]--;
            people[t[1]]++;
        }

        for(int i=1;i<n+1;i++)
            if(people[i] == n-1)
                return i;

        return -1;
    }
    public static void main(String[] args) {
        int[][] trust = {{1,3},{2,3},{3,1}};
        System.out.println(findJudge(3, trust));
    }
}

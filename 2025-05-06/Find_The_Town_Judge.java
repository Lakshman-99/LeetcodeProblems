public class Find_The_Town_Judge {
    public static int findJudge(int n, int[][] trust) {
        int[] peopleTrust = new int[n+1];

        for(int[] t : trust) {
            peopleTrust[t[0]]--;
            peopleTrust[t[1]]++;
        }

        for(int i=0;i<=n;i++)
            if(peopleTrust[i] == n-1)
                return i;

        return -1;
    }
    public static void main(String[] args) {
        int[][] people = {{1,3},{2,3}};
        System.out.println(findJudge(3, people));
    }
}

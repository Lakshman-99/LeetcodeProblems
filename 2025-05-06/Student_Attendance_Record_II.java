public class Student_Attendance_Record_II {
    public static final int MOD = 1000_000_007;
    public static int helper(int n, int cur, int a, int l, int[][][] dp) {
        if(cur == n)
            return 1;

        if(dp[cur][a][l] != -1)
            return dp[cur][a][l];

        int a_record = a == 0 ? helper(n, cur+1, a+1, 0, dp) : 0;
        int l_record = l < 2 ? helper(n, cur+1, a, l+1, dp) : 0;
        int p_record = helper(n, cur+1, a, 0, dp);

        int answer = (((a_record + l_record) % MOD) + p_record) % MOD;

        return dp[cur][a][l] = answer;
    }
    public static int checkRecordMemo(int n) {
        int[][][] dp = new int[n][2][3];
        for(int i=0;i<n;i++) {
            for(int j=0;j<2;j++) {
                for(int k=0;k<3;k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return helper(n, 0, 0, 0, dp);
    }

    public static int checkRecord(int n) {
        int[][] last = new int[2][3];
        int[][] cur = new int[2][3];

        last[0][0] = 1;

        for(int i=0;i<n;i++) {
            for(int a_count=0;a_count<2;a_count++) {
                for(int l_count=0;l_count<3;l_count++) {
                    cur[a_count][0] = (cur[a_count][0] + last[a_count][l_count]) % MOD;

                    if(a_count == 0)
                        cur[1][0] = (cur[1][0] + last[0][l_count]) % MOD;

                    if(l_count < 2)
                        cur[a_count][l_count+1] = (cur[a_count][l_count+1] + last[a_count][l_count]) % MOD;
                }
            }
            last = cur;
            cur = new int[2][3];
        }

        int answer = 0;
        for(int[] a_count : last) {
            for(int l_count : a_count) {
                answer = (answer + l_count) % MOD;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(checkRecord(10101));
    }
}

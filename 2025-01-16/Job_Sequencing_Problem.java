import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Job_Sequencing_Problem {
    public static ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
        int n = id.length;
        int[][] jobs = new int[n][3];

        for(int i=0;i<n;i++) {
            jobs[i] = new int[]{id[i], deadline[i], profit[i]};
        }

        Arrays.sort(jobs, (a, b) -> Integer.compare(b[2], a[2]));

        int[] schedules = new int[n];
        Arrays.fill(schedules, -1);

        int jobCount = 0, profits = 0;

        for(int i=0;i<n;i++) {
            int t = jobs[i][1] - 1;

            while(t >= 0 && schedules[t] != -1)
                t--;

            if(t == -1)
                continue;

            jobCount++;
            schedules[t] = jobs[i][2];
            profits += jobs[i][2];
        }


        return new ArrayList<>(Arrays.asList(jobCount, profits));
    }
    public static void main(String[] args) {
        int[] id = {1, 2, 3, 4};
        int[] deadline = {4, 1, 1, 1};
        int[] profit = {20, 1, 40, 30};

        System.out.println(JobSequencing(id, deadline, profit));

    }
}

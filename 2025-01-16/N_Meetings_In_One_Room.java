// https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1

import java.util.Arrays;
import java.util.Comparator;

public class N_Meetings_In_One_Room {
    static class Meeting {
        int start;
        int end;
        int pos;
        Meeting(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }

    public static int maxMeetings(int start[], int end[]) {
        int n = start.length;

        Meeting[] meetings = new Meeting[n];

        for(int i=0;i<n;i++)
            meetings[i] = new Meeting(start[i], end[i], i + 1);

        Arrays.sort(meetings, Comparator.comparingInt(a -> a.end));
        int ans = 1, curEnd = meetings[0].end;

        for(int i=1;i<n;i++) {
            Meeting m = meetings[i];

            if(m.start > curEnd) {
                ans++;
                curEnd = m.end;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 3, 0, 5, 8};
        int[] arr2 = {9, 2, 4, 6, 7, 9};
        System.out.print(maxMeetings(arr, arr2));
    }
}

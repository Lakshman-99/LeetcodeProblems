package amazon;

import java.util.Arrays;

public class Meeting_Rooms_II {
    public static int findRooms(int[][] arr) {
        int n = arr.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for(int i=0;i<n;i++) {
            start[i] = arr[i][0];
            end[i] = arr[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int s=0,e=0,ans=0,count=0;

        while(s<n && e<n) {
            if(start[s] < end[e]) {
                s++;
                count++;
            }
            else {
                e++;
                count--;
            }
            ans = Math.max(ans, count);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[][] meetings = {{0,30},{5,10},{15,20}};
        System.out.println(findRooms(meetings));
    }
}

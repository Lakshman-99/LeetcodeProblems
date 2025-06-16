package patterns.two_pointers;

import java.util.Arrays;

public class Boats_To_Save_People {
    public static int numRescueBoats(int[] people, int limit) {
        if(people == null || people.length == 0) return 0;

        int n = people.length;
        Arrays.sort(people);

        int boats = 0;
        int left = 0, right = n-1;
        while(left <= right) {
            int sum = people[left] + people[right];
            if(sum <= limit) {
                left++;
                right--;
            }
            else {
                right--;
            }
            boats++;
        }

        return boats;
    }
    public static void main(String[] args) {
        int[] arr = {3,2,2,1};
        System.out.println(numRescueBoats(arr, 3));
    }
}

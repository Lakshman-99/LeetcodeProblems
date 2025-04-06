package amazon;

import java.util.Arrays;

public class Koko_Eating_Bananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = Arrays.stream(piles).max().getAsInt();
        while(left < right) {
            int mid = (left + right) / 2;

            int time = 0;
            for(int pile : piles) {
                time += (pile / mid);
                if(pile % mid != 0)
                    time++;
            }

            if(time > h)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left;
    }
    public static void main(String[] args) {
        int[] arr = {3,6,7,11};
        System.out.println(minEatingSpeed(arr, 8));
    }
}

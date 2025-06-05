package patterns.sliding_window;

import java.util.HashMap;

public class Fruit_Into_Baskets {
    public static int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0, left = 0;

        for(int right=0;right<fruits.length;right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while(map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if(map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1,1,2,3,4,1,2,3,12,3,2,2,2,2,2,2,2,2,2,2,2,2};
        System.out.println(totalFruit(arr));
    }
}

// 605. Can Place Flowers

// https://leetcode.com/problems/can-place-flowers/description

public class Can_Place_Flowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length-1;

        for(int i=len;i>=0;i--) {
            if(flowerbed[i] == 0 && (i-1 == -1 || flowerbed[i-1] == 0) && (i == len || flowerbed[i+1] == 0)) {
                flowerbed[i] = 1;
                n--;
            }
        }

        return n <= 0;
    }
    public static void main(String[] args) {
        int[] arr1 = new int[]{0,0,0,0,0};
        System.out.println(canPlaceFlowers(arr1, 2));
    }
}

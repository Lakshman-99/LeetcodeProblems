public class Ugly_Number {
    public static boolean isUgly(int n) {
        if(n <= 0) return false;

        int[] nums = {5,3,2};
        for(int num : nums) {
            while(n % num == 0) {
                n /= num;
            }
        }

        return n==1;
    }
    public static void main(String[] args) {
        System.out.println(isUgly(5));
    }
}

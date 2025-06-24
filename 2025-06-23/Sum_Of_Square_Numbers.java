package patterns.two_pointers;

public class Sum_Of_Square_Numbers {
    public static boolean judgeSquareSum(int c) {
        int left = 0, right = (int) Math.sqrt(c);

        while(left <= right) {
            long check = (long) left * left + (long) right * right;
            if(check == c) {
                return true;
            }
            else if(check > c) {
                right--;
            }
            else {
                left++;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
    }
}

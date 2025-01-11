//  202. Happy Number
//
//  https://leetcode.com/problems/happy-number/description/

public class Happy_Number {
    public static boolean isHappy(int n) {
        int num = n;
        do {
            int sum = 0;
            while(num > 0) {
                int x = num%10;
                sum += x * x;
                num /= 10;
            }

            num = sum;
            if(num == 4) return false;
            if(num == 1) return true;

        } while(num != n);

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
}

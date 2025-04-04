package amazon;

public class Happy_Number {
    public static int getNext(int n) {
        int sum = 0;

        while(n > 0) {
            int d = n%10;
            sum += (d*d);
            n /= 10;
        }

        return sum;
    }
    public static boolean isHappy(int n) {
        int slow = getNext(n);
        int fast = getNext(getNext(n));

        while(slow != fast) {
            if(fast == 1) return true;
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }

        return slow == 1;
    }
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}

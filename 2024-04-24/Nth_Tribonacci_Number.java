//  1137. N-th Tribonacci Number
//
//  https://leetcode.com/problems/n-th-tribonacci-number
public class Nth_Tribonacci_Number {
    public static int tribonacci(int n) {
        if(n<=1) return n;
        if(n==2) return 1;
        int pre3=0,pre2=1,pre=1;
        for(int i=3;i<=n;i++) {
            int curr = pre3+pre2+pre;
            pre3=pre2;
            pre2=pre;
            pre=curr;
        }
        return pre;
    }
    public static void main(String[] args) {
        int n = 25;
        System.out.println(tribonacci(n));
    }
}

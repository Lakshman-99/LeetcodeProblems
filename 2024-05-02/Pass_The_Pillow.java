//  2582. Pass the Pillow
//
//  https://leetcode.com/problems/pass-the-pillow/description/

public class Pass_The_Pillow {
    public static int passThePillow(int n, int time) {
        int dir = time / (n-1);
        int mod = time % (n-1);
        if(dir % 2 == 0) {
            return mod + 1 ;
        }
        return n - mod;
    }

    public static void main(String[] args) {
        int ans = passThePillow(18, 38);
        System.out.println(ans);
    }

}

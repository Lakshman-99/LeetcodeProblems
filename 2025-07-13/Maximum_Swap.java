import java.util.Arrays;

public class Maximum_Swap {
    public static int maximumSwap(int num) {
        char[] s = Integer.toString(num).toCharArray();

        for (int i = 0; i < s.length; i++) {
            int ind = i;

            for (int j = s.length - 1; j > i; j--) {
                if (s[ind] < s[j]) {
                    ind = j;
                }
            }

            if (ind != i && s[i] < s[ind]) {
                char temp = s[i];
                s[i] = s[ind];
                s[ind] = temp;
                return Integer.parseInt(new String(s));
            }
        }

        return num;
    }
    public static void main(String[] args) {
        System.out.println(maximumSwap(10909091));
    }
}

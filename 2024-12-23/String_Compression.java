import java.util.Arrays;

public class String_Compression {
    public static int compress(char[] chars) {
        int ans = 0, c = 1, j = 1;
        char pre = chars[0];

        for(int i=1;i<=chars.length;i++) {
            if(i != chars.length && chars[i] == pre) {
                c++;
                continue;
            }
            ans++;

            if(i != chars.length)
                pre = chars[i];

            if(c != 1) {
                ans += String.valueOf(c).length();
                for(char ch : String.valueOf(c).toCharArray())
                    chars[j++] = ch;

                c = 1;
            }

            if(j < chars.length)
                chars[j++] = pre;
        }

        return ans;
    }
    public static void main(String[] args) {
        char[] arr1 = new char[]{'a','b','c','d','e','f','g','g','g','g','g','g','g','g','g','g','g','g','a','b','c'};
        System.out.println(compress(arr1));
    }
}

import java.util.*;
public class Roman_to_Integer {
    public static int romanToInt(String s) {
        int ans = 0, i;
        HashMap<Character, Integer> hm = new HashMap<>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        for(i=s.length()-1;i>=1;i--) {
            if((s.charAt(i) == 'L' || s.charAt(i) == 'C') && s.charAt(i-1) == 'X') {
                ans = ans + hm.get(s.charAt(i--)) - hm.get(s.charAt(i));
            }
            else if((s.charAt(i) == 'D' || s.charAt(i) == 'M') && s.charAt(i-1) == 'C') {
                ans = ans + hm.get(s.charAt(i--)) - hm.get(s.charAt(i));
            }
            else if((s.charAt(i) == 'V' || s.charAt(i) == 'X') && s.charAt(i-1) == 'I') {
                ans = ans + hm.get(s.charAt(i--)) - hm.get(s.charAt(i));
            }
            else {
                ans = ans + hm.get(s.charAt(i));
            }
        }

        if(i == 0) {
            ans = ans + hm.get(s.charAt(0));
        }

        return ans;
    }
    public static void main(String[] args) {
        int ans = romanToInt("III");
        System.out.println(ans);
    }
}

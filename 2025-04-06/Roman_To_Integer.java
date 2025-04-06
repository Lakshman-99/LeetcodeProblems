package amazon;

import java.util.HashMap;

public class Roman_To_Integer {
    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        int ans = 0, i;

        for(i=0;i<s.length()-1;i++) {
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1)))
                ans -= map.get(s.charAt(i));
            else
                ans += map.get(s.charAt(i));
        }

        return ans + map.get(s.charAt(i));
    }
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}

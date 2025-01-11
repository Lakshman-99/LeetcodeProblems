import java.util.*;
public class Redistribute_Characters_to_Make_All_Strings_Equal {
    public static boolean makeEqual(String[] words) {
        if(words.length <= 1) {
            return true;
        }

        HashMap<Character, Integer> hm = new HashMap<>();

        for(String str : words) {
            for(Character i : str.toCharArray()) {
                if(hm.containsKey(i)) {
                    hm.put(i, hm.get(i) + 1);
                } else {
                    hm.put(i, 1);
                }
            }
        }

        for (int num : hm.values()) {
            if (num % words.length != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean ans = makeEqual(new String[]{"abc","aabc","bc"});
        System.out.println(ans);
    }
}

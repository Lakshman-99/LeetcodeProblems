package patterns.two_pointers;

public class Reverse_Only_Letters {
    public static String reverseOnlyLetters(String s) {
        if(s == null || s.isEmpty()) return "";

        char[] result = new char[s.length()];
        int left = 0, right = s.length()-1;

        while(left <= right) {
            while(left <= right && !Character.isLetter(s.charAt(left))) {
                result[left] = s.charAt(left++);
            }
            while(left <= right && !Character.isLetter(s.charAt(right))) {
                result[right] = s.charAt(right--);
            }
            if(left > right) continue;

            result[left] = s.charAt(right);
            result[right] = s.charAt(left);
            left++;
            right--;
        }

        return new String(result);
    }
    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}

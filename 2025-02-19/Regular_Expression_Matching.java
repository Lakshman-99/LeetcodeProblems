public class Regular_Expression_Matching {
    public static boolean isMatch(String s, String p) {
        if (p.isEmpty())
            return s.isEmpty();

        boolean is_match = !s.isEmpty() && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0));
        if (p.length() > 1 && p.charAt(1) == '*') {
            if (isMatch(s, p.substring(2)))
                return true;

            if(is_match)
                return isMatch(s.substring(1), p);

        } else {
            if(is_match)
                return isMatch(s.substring(1), p.substring(1));

        }
        return false;
    }
    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        System.out.println(isMatch(s, p));
    }
}

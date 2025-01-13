public class Adding_Spaces_To_A_String {
    public static String addSpaces(String s, int[] spaces) {
        StringBuilder str = new StringBuilder();
        int lastInd = 0, n = s.length();

        for(int space : spaces) {
            str.append(s, lastInd, space).append(" ");
            lastInd = space;
        }
        str.append(s, lastInd, n);

        return str.toString();
    }
    public static void main(String[] args) {
        String s = "LeetcodeHelpsMeLearn";
        int[] arr = new int[]{8,13,15};

        System.out.println(addSpaces(s, arr));
    }
}

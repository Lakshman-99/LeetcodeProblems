public class Title_Helper {
    public static String manipulateString(String input) {
        String[] words = input.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (i > 0) {
                result.append("_");
            }
            result.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1));
        }        return result.toString();
    }
    public static void main(String[] args) {
        String input = "Find Closest Number to Zero\n";
        String result = manipulateString(input);
        System.out.println(result);
    }
}

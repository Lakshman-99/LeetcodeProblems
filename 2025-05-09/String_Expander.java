import java.util.*;

public class String_Expander {
    public static String decode(String input) {
        StringBuilder answer = new StringBuilder();
        int count = 0;
        for(char c:input.toCharArray()) {
            if(Character.isLetter(c)) {
                answer.append(c);
            }
            if(Character.isDigit(c)) {
                count = count*10 + (c-'0');
            }
        }

        String decoded = answer.toString();
        for(int i=1;i<count;i++){
            answer.append(decoded);
        }

        return answer.toString();
    }
    public static String funcPatternExpander(String inputStr)
    {
        // Write your code here
        StringBuilder input = new StringBuilder(inputStr);
        Stack<Integer> stack = new Stack<>();
        int index = 0, n= input.length();
        while(index < n) {
            char c = input.charAt(index);

            if(c == '(') {
                stack.add(index);
            }
            else if(!stack.isEmpty() && c == '}') {
                int start = stack.pop();
                String sub = input.substring(start, index+1);
                String decoded = decode(sub);
                input = new StringBuilder(input.substring(0, start) + decoded + input.substring(index+1));

                index--;
                n = input.length();
            }
            index++;
        }

        return input.toString();
    }

    public static void main(String[] args)
    {
        String result = funcPatternExpander("(ef((ab){2}cd){2}{2}");
        System.out.print(result);
    }
}

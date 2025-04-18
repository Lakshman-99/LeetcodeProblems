import java.util.*;

public class Text_Justification {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> answer = new ArrayList<>();
        List<String> buffer = new ArrayList<>();
        int curLength = 0, i = 0, n = words.length;

        do {
            String word = i >= n ? "" : words[i];
            if(i == n || curLength + word.length() == maxWidth || curLength + word.length() + 1 > maxWidth) {
                int diffCorrect = 0;
                if(curLength + word.length() == maxWidth) {
                    curLength += word.length();
                    buffer.add(word);
                    diffCorrect = 1;
                    word = i+1 >= n ? "" : words[++i];
                }

                int diff = maxWidth - curLength + buffer.size() - diffCorrect;

                StringBuilder sb = new StringBuilder();
                for(int j=0;j<buffer.size();j++) {
                    sb.append(buffer.get(j));
                    int count = (diff / Math.max(1, buffer.size()-1-j)) + (diff % Math.max(1, buffer.size()-1-j) == 0 ? 0 : 1);
                    count = i == n ? 1 : count;

                    while(diff-- > 0 && count-- > 0) sb.append(" ");
                    diff++;
                }
                if(i == n) {
                    diff--;
                    while(diff-- >= 0) sb.append(" ");
                }
                answer.add(sb.toString());

                curLength = 0;
                buffer.clear();
            }
            if(!word.isEmpty()) {
                curLength += word.length() + 1;
                buffer.add(word);
            }
            i++;
        } while (!buffer.isEmpty());

        for(String w : answer)
            System.out.println("\"" + w + "\"");

        return answer;
    }
    public static void main(String[] args) {
        String[] words = {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
        System.out.println(fullJustify(words, 16));
    }
}

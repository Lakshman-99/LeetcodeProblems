import java.util.HashSet;

public class Calculate_Score_After_Performing_Instructions {
    public static long calculateScore(String[] instructions, int[] values) {
        int ind = 0, n = values.length;
        long score = 0;
        HashSet<Integer> visited = new HashSet<>();

        while(ind >= 0 && ind < n) {
            if(visited.contains(ind)) break;

            visited.add(ind);
            if(instructions[ind].equals("add")) {
                score += values[ind++];
            }
            else if(instructions[ind].equals("jump")) {
                ind += values[ind];
            }
            else {
                break;
            }
        }

        return score;
    }
    public static void main(String[] args) {
        String[] instructions = {"jump", "add", "add", "jump", "add", "jump"};
        int[] values = {2, 1, 3, 1, -2, -3};
        System.out.println(calculateScore(instructions, values));
    }
}

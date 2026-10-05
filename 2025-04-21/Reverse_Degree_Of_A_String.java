import java.util.stream.IntStream;

public class Reverse_Degree_Of_A_String {
    public static int reverseDegree(String s) {
        return IntStream.range(0, s.length()).reduce(0, (sum, ind) -> sum + (26 - (s.charAt(ind) - 'a')) * (ind+1));
    }
    public static void main(String[] args) {
        System.out.println(reverseDegree("abc"));
    }
}

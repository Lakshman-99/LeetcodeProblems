import java.util.*;

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        if(asteroids == null || asteroids.length == 0) return new int[]{};

        Stack<Integer> stack = new Stack<>();
        for(int ast : asteroids) {
            boolean flag = true;
            while(!stack.isEmpty() && flag && stack.peek() > 0 && ast < 0) {
                int diff = Math.abs(stack.peek()) - Math.abs(ast);
                if(diff == 0) {
                    stack.pop();
                    flag = false;
                }
                else if(diff > 0) flag = false;
                else stack.pop();
            }
            if(flag)
                stack.add(ast);
        }

        int[] result = new int[stack.size()];
        for(int i=result.length-1;i>=0;i--)
            result[i] = stack.pop();

        return result;
    }
    public static void main(String[] args) {
        int[] arr = {-1,-1,-1,10,-120};
        System.out.println(Arrays.toString(asteroidCollision(arr)));
    }
}

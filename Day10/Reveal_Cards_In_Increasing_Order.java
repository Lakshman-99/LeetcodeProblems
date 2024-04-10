//  950. Reveal Cards In Increasing Order
//
//  https://leetcode.com/problems/reveal-cards-in-increasing-order/description/

import java.util.*;

public class Reveal_Cards_In_Increasing_Order {
    public static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> queue = new LinkedList<>();
        int n = deck.length;
        queue.addFirst(deck[n-1]);

        for(int i=n-2;i>=0;i--) {
            int num = deck[i];
            int last = queue.removeLast();
            queue.addFirst(last);
            queue.addFirst(num);
        }

        int[] ans = new int[n];
        int ind = 0;
        for(Integer i : queue) {
            ans[ind++] = i;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = deckRevealedIncreasing(new int[]{17,13,11,2,3,5,7});
        System.out.print(Arrays.toString(arr));
    }
}

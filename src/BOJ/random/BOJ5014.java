package BOJ.random;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ5014 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int f = sc.nextInt();
        int s = sc.nextInt();
        int g = sc.nextInt();
        int u = sc.nextInt();
        int d = sc.nextInt();

        int[] memo = new int[f + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[s] = 0;

        Deque<int[]> deque = new LinkedList<>();
        deque.add(new int[]{s, 0});
        while (!deque.isEmpty()) {
            int[] arr = deque.pollFirst();
            int next1 = arr[0] + u;
            int next2 = arr[0] - d;
            int press = arr[1] + 1;

            if (next1 >= 1 && next1 <= f && memo[next1] > press) {
                memo[next1] = press;
                deque.addLast(new int[]{next1, press});
            }

            if (next2 >= 1 && next2 <= f && memo[next2] > press) {
                memo[next2] = press;
                deque.addLast(new int[]{next2, press});
            }
        }

        if (memo[g] == Integer.MAX_VALUE) {
            System.out.println("use the stairs");
        } else {
            System.out.println(memo[g]);
        }
    }
}

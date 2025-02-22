package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2257 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] stack = new int[100];
        int prev = 0;
        int cnt = 0;
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if (cur == 'H') {
                prev = 1;
                stack[cnt] += 1;
            } else if (cur == 'C') {
                prev = 12;
                stack[cnt] += 12;
            } else if (cur == 'O') {
                prev = 16;
                stack[cnt] += 16;
            } else if (cur == '(') {
                stack[++cnt] = 0;
            } else if (cur == ')') {
                prev = stack[cnt--];
                stack[cnt] += prev;
            } else if (cur > '1' && cur <= '9') {
                stack[cnt] += prev * (cur - '1');
            }
        }

        System.out.println(stack[0]);
    }
}

package BOJ.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Postfix {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Character> deque = new LinkedList<>();

        String input = br.readLine();
        char target;

        for (int i = 0; i < input.length(); i++) {
            target = input.charAt(i);
            switch (target) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!deque.isEmpty() && getPriority(deque.peek()) >= getPriority(target)) {
                        sb.append(deque.pop());
                    }
                    deque.push(target);
                    break;
                case '(':
                    deque.push(target);
                    break;
                case ')':
                    while (!deque.isEmpty() && deque.peek() != '(') {
                        sb.append(deque.pop());
                    }
                    deque.pop();
                    break;
                default:
                    sb.append(target);
            }
        }

        while (!deque.isEmpty()) {
            sb.append(deque.pop());
        }
        System.out.println(sb);
    }

    private static int getPriority(final char target) {
        switch (target) {
            case '+':
            case '-':
                return 0;
            case '*':
            case '/':
                return 1;
        }
        return -1;
    }

}

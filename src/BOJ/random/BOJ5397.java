package BOJ.random;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ5397 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Deque<Character> left = new LinkedList<>();
            Deque<Character> right = new LinkedList<>();
            String input = sc.next();
            for (int j = 0; j < input.length(); j++) {
                char ch = input.charAt(j);
                if (ch == '>') {
                    if (!right.isEmpty()) {
                        left.addLast(right.pollFirst());
                    }
                } else if (ch == '<') {
                    if (!left.isEmpty()) {
                        right.addFirst(left.pollLast());
                    }
                } else if (ch == '-') {
                    if (!left.isEmpty()) {
                        left.pollLast();
                    }
                } else {
                    left.addLast(ch);
                }
            }
            StringBuilder answer = new StringBuilder();
            while (!left.isEmpty()) {
                answer.append(left.pollFirst());
            }
            while (!right.isEmpty()) {
                answer.append(right.pollFirst());
            }
            System.out.println(answer);
        }
    }

}

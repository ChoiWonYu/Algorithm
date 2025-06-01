package BOJ.random;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class BOJ2504 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        Deque<String> d = new LinkedList<>();
        int answer = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                d.addFirst("(");
            } else if (c == ')') {
                int sum = 0;
                while (!d.isEmpty() && !d.peekFirst().equals("(")) {
                    String cur = d.pollFirst();
                    if (!Character.isDigit(cur.charAt(0))) {
                        System.out.println(0);
                        return;
                    }
                    sum += Integer.parseInt(cur);
                }
                if (d.isEmpty() || !Objects.equals(d.peekFirst(), "(")) {
                    System.out.println(0);
                    return;
                }
                d.pollFirst();
                d.addFirst(sum == 0 ? "2" : String.valueOf(sum * 2));
            } else if (c == '[') {
                d.addFirst("[");
            } else {
                int sum = 0;
                while (!d.isEmpty() && !Objects.equals(d.peekFirst(), "[")) {
                    String cur = d.pollFirst();
                    if (!Character.isDigit(cur.charAt(0))) {
                        System.out.println(0);
                        return;
                    }
                    sum += Integer.parseInt(cur);
                }
                if (d.isEmpty() || !Objects.equals(d.peekFirst(), "[")) {
                    System.out.println(0);
                    return;
                }
                d.pollFirst();
                d.addFirst(sum == 0 ? "3" : String.valueOf(sum * 3));
            }
        }
        while (!d.isEmpty()) {
            if (!Character.isDigit(d.peekFirst().charAt(0))) {
                System.out.println(0);
                return;
            }
            answer += Integer.parseInt(d.pollFirst());
        }

        System.out.println(answer);
    }
}

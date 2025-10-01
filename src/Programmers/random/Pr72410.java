package Programmers.random;

import java.util.Deque;
import java.util.LinkedList;

public class Pr72410 {

    public String solution(String new_id) {
        Deque<Character> d = new LinkedList<>();
        new_id = new_id.toLowerCase();
        for (int i = 0; i < new_id.length(); i++) {
            char cur = new_id.charAt(i);
            if (Character.isAlphabetic(cur) || Character.isDigit(cur)
                || cur == '-' || cur == '_' || cur == '.') {
                if (cur == '.' && !d.isEmpty() && d.peekLast() == '.') {
                    continue;
                }
                d.addLast(cur);
            }
        }

        if (!d.isEmpty() && d.peekFirst() == '.') {
            d.pollFirst();
        }
        if (!d.isEmpty() && d.peekLast() == '.') {
            d.pollLast();
        }
        if (d.isEmpty()) {
            d.add('a');
        }
        while (d.size() >= 16) {
            d.pollLast();
        }
        if (!d.isEmpty() && d.peekLast() == '.') {
            d.pollLast();
        }
        char lastChar = d.peekLast();
        while (d.size() < 3) {
            d.addLast(lastChar);
        }
        String answer = "";
        for (char c : d) {
            answer += c;
        }
        return answer;
    }
}

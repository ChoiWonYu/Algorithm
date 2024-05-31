package Programmers.random_2nd;

import java.util.*;

public class Pr76502 {

    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            String cur = s.substring(i, s.length()) + s.substring(0, i);
            if (isValid(cur)) {
                answer++;
            }
        }
        return answer;
    }

    public boolean isValid(String s) {
        Deque<Character> d = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '{' || cur == '[') {
                d.addLast(cur);
            } else {
                if (d.isEmpty()) {
                    return false;
                }
                if (cur == ')' && d.pollLast() != '(') {
                    return false;
                } else if (cur == '}' && d.pollLast() != '{') {
                    return false;
                } else if (cur == ']' && d.pollLast() != '[') {
                    return false;
                }
            }
        }
        return d.isEmpty();
    }
}

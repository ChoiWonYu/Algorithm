package Programmers.random_2nd;

import java.util.Deque;
import java.util.LinkedList;

public class Pr131704 {

    public int solution(int[] order) {
        int answer = 0;
        int len = order.length;

        Deque<Integer> main = new LinkedList<Integer>();
        Deque<Integer> sub = new LinkedList<Integer>();

        for (int i = 1; i <= len; i++) {
            main.addLast(i);
        }

        int cur;
        for (int i = 0; i < len; i++) {
            cur = order[i];
            if (!main.isEmpty() && main.peekFirst() == cur) {
                main.pollFirst();
                answer++;
            } else if (!sub.isEmpty() && sub.peekLast() == cur) {
                sub.pollLast();
                answer++;
            } else {
                while (!main.isEmpty() && main.peekFirst() <= cur) {
                    sub.addLast(main.pollFirst());
                }
                if (sub.isEmpty() || sub.peekLast() != cur) {
                    return answer;
                }
                sub.pollLast();
                answer++;
            }
        }
        return answer;
    }
}

package Programmers.random;

import java.util.Deque;
import java.util.LinkedList;

public class Pr118667 {

    public int solution(int[] queue1, int[] queue2) {
        Deque<Integer> d1 = new LinkedList<>();
        Deque<Integer> d2 = new LinkedList<>();
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;
        for (int n : queue1) {
            d1.addLast(n);
            sum1 += n;
        }
        for (int n : queue2) {
            d2.addLast(n);
            sum2 += n;
        }

        int firstNum1 = d1.peekFirst();
        int lastNum1 = d1.peekLast();
        int len1 = d1.size();

        int firstNum2 = d2.peekFirst();
        int lastNum2 = d2.peekLast();
        int len2 = d2.size();

        while (sum1 != sum2) {
            answer++;
            int pollNum;
            if (sum1 > sum2) {
                pollNum = d1.pollFirst();
                sum1 -= pollNum;
                d2.addLast(pollNum);
                sum2 += pollNum;
            } else {
                pollNum = d2.pollFirst();
                sum2 -= pollNum;
                d1.addLast(pollNum);
                sum1 += pollNum;
            }

            if (answer > 2 * (d1.size() + d2.size())) {
                return -1;
            }
        }
        return answer;
    }
}

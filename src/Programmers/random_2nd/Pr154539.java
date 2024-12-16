package Programmers.random_2nd;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Pr154539 {

    public int[] solution(int[] numbers) {
        int len = numbers.length;
        Deque<Integer> nums = new LinkedList<>();
        int[] answer = new int[len];
        Arrays.fill(answer, -1);
        int cur = 0;
        for (int i = len - 1; i >= 0; i--) {
            cur = numbers[i];
            while (!nums.isEmpty()) {
                if (nums.peekLast() > cur) {
                    answer[i] = nums.peekLast();
                    break;
                } else {
                    nums.pollLast();
                }
            }
            nums.addLast(cur);
        }
        return answer;
    }
}

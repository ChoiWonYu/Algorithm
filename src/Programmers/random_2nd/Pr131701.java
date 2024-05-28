package Programmers.random_2nd;

import java.util.*;

public class Pr131701 {

    public int solution(int[] elements) {
        Set<Integer> s = new HashSet<>();
        int len = elements.length;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < len; j++) {
                int sum = 0;
                for (int k = j; k < i + j; k++) {
                    sum += elements[k % len];
                }
                s.add(sum);
            }
        }
        return s.size();
    }
}

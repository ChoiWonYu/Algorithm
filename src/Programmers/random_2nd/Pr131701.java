package Programmers.random_2nd;

import java.util.*;

public class Pr131701 {

    public int solution(int[] elements) {
        Set<Integer> s = new HashSet<>();

        int len = elements.length;
        int[] arr = new int[2 * len];
        arr[0] = elements[0];
        for (int i = 1; i < 2 * len; i++) {
            arr[i] = arr[i - 1] + elements[i % len];
        }

        for (int i = 0; i < len * 2; i++) {
            if (i < len) {
                s.add(arr[i]);
                for (int j = 0; j < i; j++) {
                    s.add(arr[i] - arr[j]);
                }
            } else {
                for (int j = i - (len - 1); j < i; j++) {
                    s.add(arr[i] - arr[j]);
                }
            }
        }
        return s.size();
    }
}

package Programmers.random_2nd;

import java.util.HashSet;
import java.util.Set;

public class Pr132265 {

    public int solution(int[] topping) {
        int answer = 0;
        int[] leftCumSum = getLeftCumSum(topping);
        int[] rightCumSum = getRightCumSum(topping);
        for (int i = 0; i < topping.length - 1; i++) {
            if (leftCumSum[i] == rightCumSum[i + 1]) {
                answer++;
            }
        }
        return answer;
    }

    public int[] getLeftCumSum(int[] arr) {
        int[] result = new int[arr.length];
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
            s.add(n);
            result[i] = s.size();
        }
        return result;
    }

    public int[] getRightCumSum(int[] arr) {
        int[] result = new int[arr.length];
        Set<Integer> s = new HashSet<>();
        for (int i = arr.length - 1; i > 0; i--) {
            int n = arr[i];
            s.add(n);
            result[i] = s.size();
        }
        return result;
    }
}

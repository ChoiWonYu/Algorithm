package Programmers.Basic;

import java.util.Arrays;

public class Avg {
    public double solution(int[] arr) {
        double answer = Arrays.stream(arr).average().getAsDouble();
        return answer;
    }

    public static void main(String[] args) {

    }
}

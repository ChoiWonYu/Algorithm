package Programmers.Basic;

import java.util.Arrays;

public class ReverseIntArr {
    public static int[] solution(long n) {
        return new StringBuilder().append(String.valueOf(n)).reverse().chars().map(Character::getNumericValue).toArray();
    }

    public static void main(String[] args) {

    }
}

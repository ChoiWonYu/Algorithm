package Programmers.Basic;

import java.util.Arrays;

public class HarshadNumber {
    public static boolean solution(int x) {
        int sum= Arrays.stream(Integer.toString(x).split(""))
                .mapToInt(st->Integer.valueOf(st))
                .sum();
//        int sum=num.chars().map(ch->ch-'0').sum();

        return x%sum==0;
    }

    public static void main(String[] args) {
        boolean result=solution(10);
        System.out.println(result);
    }
}

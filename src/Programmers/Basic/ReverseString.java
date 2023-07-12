package Programmers.Basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ReverseString {
    public long solution(long n) {
        String s=String.valueOf(n);
        String[]arr=s.split("");
        Arrays.sort(arr,Collections.reverseOrder());
        StringBuilder sb=new StringBuilder();
        for(String st:arr) sb.append(st);
        return Long.parseLong(sb.toString());
    }

    public static void main(String[] args) {

    }
}

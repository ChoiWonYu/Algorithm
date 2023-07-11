package Programmers.Basic;

import java.util.Arrays;

public class XN {
    public static long[] solution(int x, int n) {
        long[] answer=new long[n];
        long num=x;
        for(int i=0;i<n;i++) {
            answer[i] = num;
            num+=x;
        }
        return answer;
    }

    public static void main(String[] args) {
        long[] result=solution(2,5);
        System.out.println(Arrays.toString(result));
    }
}

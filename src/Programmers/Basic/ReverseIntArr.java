package Programmers.Basic;

import java.util.Arrays;

public class ReverseIntArr {
    public static int[] solution(long n) {
        int l=(int)Math.log10(n)+1;
        int[] answer=new int[l];
        l--;
        String[]s=String.valueOf(n).split("");

        for(String st:s){
            answer[l--]=Integer.parseInt(st);
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}

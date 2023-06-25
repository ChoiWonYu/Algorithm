package Programmers.Basic;
import java.util.*;

public class Fruit {
    public static int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int answer = 0;
        for(int i=score.length;i>=m;i-=m){
            answer+=score[i-m]*m;
        }
        return answer;
    }

    public static void main(String[] args){
        int result=solution(4,3, new int[] {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2});
        System.out.println(result);
    }

}

package Programmers.Basic;

import java.util.*;

public class Budget {
    public static int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int i:d){
            budget-=i;
            if(budget<0)break;

            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[]d={1,3,2,5,4};
        int budget=9;
        int result=solution(d,budget);
        System.out.println(result);
    }
}

package Programmers.Sort;

import java.util.*;

public class Kth {

    public static int[] solution(int[] array,int[][] commands){
        int[] answer=new int [commands.length];
        int idx=0;
        for(int i[]:commands){
            int[] tmp=Arrays.copyOfRange(array,i[0]-1,i[1]);
            Arrays.sort(tmp);

            answer[idx++]=tmp[i[2]-1];
        }
        return answer;
    }

    public static void main(String[] args){
        int[][] arr={{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] array={1, 5, 2, 6, 3, 7, 4};
        int[ ]result=solution(array,arr);
        for(int i:result){
            System.out.println(i);
        }
    }
}

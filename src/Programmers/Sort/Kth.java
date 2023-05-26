package Programmers.Sort;

import java.util.*;

public class Kth {
    public static ArrayList<Integer> sliceArr(int[] array,int startIdx,int endIdx){
        ArrayList<Integer> result=new ArrayList<Integer>();
        for(int i=startIdx;i<=endIdx;i++){
            result.add(array[i]);
        }
        return result;
    }

    public static int[] solution(int[] array,int[][] commands){
        int[] answer=new int [commands.length];
        int idx=0;
        for(int i[]:commands){
            ArrayList<Integer>sliceArr=sliceArr(array,i[0]-1,i[1]-1);
            Collections.sort(sliceArr);
            answer[idx]=sliceArr.get(i[2]-1);
            if(idx<commands.length-1)idx++;
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

package Programmers.Sort;
import java.util.*;

public class HIndex {
    public static boolean isValid(int[] arr,int h){

        int count=0;
        for(int i=arr.length-1;i>=0;i--){
            if(h<=arr[i])count++;
            else break;
        }
        return count>=h;
    }

    public static int solution(int[] citations){
        Arrays.sort(citations);
        int hIdx=0;

        while(true){
            boolean flag=isValid(citations,hIdx+1);
            if(flag)hIdx++;
            else break;
        }

        return hIdx;
    };

    public static void main(String[] args){
        int[] arr={3, 0, 6, 1, 5};
        int result=solution(arr);
        System.out.println(result);
    }

}


package Programmers.stackqueue;
import java.util.*;

class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer>a=new ArrayList<Integer>();
        int preNum=10;
        for(int i:arr){
            if(i==preNum)continue;
            preNum=i;
            a.add(i);
        }
        int[] answer=new int[a.size()];
        int idx=0;
        for(int i:a){
            answer[idx++]=i;
        }
        return answer;
    }
}

public class SameNum {
    public static void main(String[] args){
    }
}

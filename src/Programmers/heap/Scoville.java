package Programmers.heap;
import java.util.*;

public class Scoville {
    public static int solution(int[] scoville,int K){
        PriorityQueue<Integer> minH=new PriorityQueue<>();
        for(int i:scoville){
            minH.add(i);
        }
        int count=0;
        while(minH.peek()<K&&minH.size()!=1){
            Integer s1=minH.poll();
            Integer s2=minH.poll();
            minH.add(s1+s2*2);
            count++;
        }

        if(minH.size()==1&&minH.peek()<K)return -1;
        return count;
    }

    public static void main(String[] args){
        int[]i={1, 2, 3, 9, 10, 12};
        int answer=solution(i,7);
        System.out.println(answer);
    }
}

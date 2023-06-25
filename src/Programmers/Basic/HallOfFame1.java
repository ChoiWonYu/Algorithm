package Programmers.Basic;
import java.util.*;

public class HallOfFame1 {
        public static int[] solution(int k, int[] score) {
            PriorityQueue pq=new PriorityQueue<Integer>();
            int[] answer = new int[score.length];
            int idx=0;
            for(int i:score){
                pq.add(i);
                if(pq.size()>k)pq.poll();

                answer[idx++]=(int)pq.peek();
            }

            return answer;
        }
    public static void main(String[] args){
        int[ ] socore={10, 100, 20, 150, 1, 100, 200};
        int []result=solution(3,socore);
        System.out.println(Arrays.toString(result));
    }
}

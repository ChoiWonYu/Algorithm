package Programmers.Basic;
import java.util.*;

public class HallOfFame1 {
        public static int[] solution(int k, int[] score) {
            List l=new ArrayList<>();
            int[] answer = new int[score.length];
            int idx=0;
            for(int i:score){
                l.add(i);
                l.sort(Collections.reverseOrder());
                answer[idx++]=l.size()<k?(int)l.get(l.size()-1):(int)l.get(k-1);
            }

            return answer;
        }
    public static void main(String[] args){
        int[ ] socore={0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
        int []result=solution(4,socore);
        System.out.println(Arrays.toString(result));
    }
}

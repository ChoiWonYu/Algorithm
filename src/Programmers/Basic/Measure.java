package Programmers.Basic;
import java.util.*;

public class Measure {

    public static Set getMeasure(int num){
        Set<Integer> s=new HashSet<>();
        for(int i=1;i<=Math.sqrt(num);i++){
            if(num%i==0) {
                s.add(i);
                s.add(num/i);
            }
            }
        return s;
        }



    public static int solution(int left, int right) {
        int answer = 0;
        for(int i=left;i<=right;i++){
            int size=getMeasure(i).size();
            answer+=size%2==0?i:-i;
        }
        return answer;
    }

    public static void main(String[]args){
        int result=solution(24,27);
        System.out.println(result);
    }
}

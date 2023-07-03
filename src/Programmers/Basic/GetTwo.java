package Programmers.Basic;
import java.util.*;

public class GetTwo {
    public static int[] solution(int[] numbers) {
        Set<Integer> s=new HashSet<Integer>();
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                s.add(numbers[i]+numbers[j]);
            }
        }
        int[] answer = new int[s.size()];

        int idx=0;
        for(int i:s){
            answer[idx++]=i;
        }
        Arrays.sort(answer);
        return answer;
    }
    public static void main(String[] args) {
        int[] numbers={1,7,2,9,1};
        int[] result=solution(numbers);
        System.out.println(Arrays.toString(result));
    }

}

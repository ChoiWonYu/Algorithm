package Programmers.Basic;
import java.util.*;

public class RemoveMin {
    public int[] solution(int[] arr) {
        if(arr.length==1)return new int[] {-1};
        int min=Arrays.stream(arr).min().getAsInt();
        int[] answer = Arrays.stream(arr).filter(n->n!=min).toArray();
        return answer;
    }

    public static void main(String[] args) {

    }
}

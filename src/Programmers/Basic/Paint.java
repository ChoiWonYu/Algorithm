package Programmers.Basic;
import java.util.*;

public class Paint {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int max = 0;

        for (int i = 0; i < section.length; i++) {
            if (section[i] < max) {
                continue;
            }

            answer += 1;
            max = section[i] + m;
        }

        return answer;
    }

    public static void main(String[] args){

    }
}

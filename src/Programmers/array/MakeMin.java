package Programmers.array;

import java.util.*;

public class MakeMin {

    public int solution(int []A, int []B){
        Arrays.sort(A);
        Arrays.sort(B);

        int len = A.length - 1;
        int answer = 0;
        for (int i = 0; i <= len; i++) {
            answer += A[len - i] * B[i];
        }

        return answer;
    }
}

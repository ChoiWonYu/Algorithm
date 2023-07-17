package inflearn.array;

import java.util.*;

public class RSP {
    public static String[] solution(int[] A,int[] B){
        String[] answer = new String[A.length];
        for (int i = 0; i < A.length; i++) {
            if(A[i]==B[i])answer[i]="D";
            else if(A[i]-B[i]==1||A[i]-B[i]==-2)answer[i]="A";
            else answer[i]="B";
        }
        return answer;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i]=sc.nextInt();
        }

        String[] result = solution(a, b);
        for (String s : result) {
            System.out.println(s);
        }


    }
}

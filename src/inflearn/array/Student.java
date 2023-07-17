package inflearn.array;

import java.util.*;

public class Student {
    public static int solution(int[] students){
        int max=students[0];
        int cnt=1;
        for(int i=1;i<students.length;i++){
            if (students[i] >max) {
                max = students[i];
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] students = new int[n];

        for (int i = 0; i < n; i++) {
            students[i] = sc.nextInt();
        }

        int result = solution(students);
        System.out.println(result);
    }
}

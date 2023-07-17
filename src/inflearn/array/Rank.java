package inflearn.array;

import java.util.*;

public class Rank {
    public static String solution(int[] arr) {
        StringBuilder sb=new StringBuilder();
        for (int i : arr) {
            int cnt=1;
            for (int j : arr) {
                if(j>i)cnt++;
            }
            sb.append(cnt+" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }

        String result = solution(arr);
        System.out.println(result);
    }
}

package BOJ.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NQueen {

    static int count,N;
    static int[] arr;

    public static void dfs(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth]=i;
            if (canLocate(depth,i)) {
                dfs(depth + 1);
            }
        }
    }

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new int[N];
        dfs(0);
        System.out.println(count);
    }

    private static boolean canLocate(int row,int col) {
        for (int i = 0; i < row; i++) {
            if(arr[i]==col)return false;
            if(Math.abs(arr[i]-col)==Math.abs(i-row))return false;
        }
        return true;
    }
}

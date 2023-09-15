package BOJ.backtracking;

import java.util.*;

public class NM3 {

    static int N,M;
    static int[] result,nums;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        nums = new int[N];

        for(int i=0;i<N;i++)nums[i]=i+1;

        result = new int[M];

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for(int i:result)sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            result[depth]=i+1;
            dfs(depth + 1);
        }
    }
}

package BOJ.backtracking;

import java.util.*;

public class NM2 {

    static int N,M;
    static StringBuilder sb = new StringBuilder();
    static int[]result;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();

        result = new int[M];

        dfs( 1,0);

        System.out.println(sb);
    }

    private static void dfs(int startNum,int depth) {
        if (depth == M) {
            for(int i:result)sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = startNum; i <= N; i++) {
                result[depth]=i;
                dfs( i + 1,depth+1);
        }

    }


}

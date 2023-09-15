package BOJ.backtracking;

import java.util.*;

public class NM1 {
    static int N,M;
    static int[] result;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        int[] nums = new int[N];
        visited = new boolean[N];
        result = new int[M];
        for(int i=1;i<=N;i++)nums[i-1]=i;
        dfs(N, 0);
        System.out.println(sb);
    }

    private static void dfs(int n, int r) {
        if(r==M){
            for(int i:result) sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[r] = i + 1;
                dfs(n, r + 1);
                visited[i] = false;
            }
        }
    }
}

package BOJ.dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Virus {
    static int N,M,cnt=0;
    static boolean[][] comp;
    static boolean[] visited;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i,comp1,comp2;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        comp = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];


        for (i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            comp1=Integer.parseInt(st.nextToken());
            comp2=Integer.parseInt(st.nextToken());

            comp[comp1][comp2]=true;
            comp[comp2][comp1]=true;
        }

        visited[1]=true;
        dfs(1);



        System.out.println(cnt);
    }

    private static void dfs(int num) {
        int i;
        for (i = 1; i <= N; i++) {
            if(!comp[num][i]||visited[i])continue;

            visited[i]=true;
            cnt++;
            dfs(i);
        }
    }
}

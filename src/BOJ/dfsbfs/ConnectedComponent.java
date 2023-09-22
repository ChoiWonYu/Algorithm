package BOJ.dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ConnectedComponent {

    static int N,M,cnt;
    static boolean[][]graph;
    static boolean[] visited;
    static int[]nums;

    public static void main(String[] args)throws Exception {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i,num1,num2;
        cnt=0;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph=new boolean[N+1][N+1];
        visited=new boolean[N+1];
        nums = new int[N+1];

        for (i = 1; i <= N; i++) nums[i] = i;

        for (i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            num1= Integer.parseInt(st.nextToken());
            num2= Integer.parseInt(st.nextToken());

            graph[num1][num2]=true;
            graph[num2][num1]=true;
        }

        for (i = 1; i <= N; i++) {
            if(visited[i])continue;
            dfs(i);
            cnt++;
        }

        System.out.println(cnt);

    }

    private static void dfs(int num) {
        visited[num]=true;
        for (int i = 1; i <= N; i++) {
            if(i==num)continue;
            if(visited[i])continue;

            if(graph[num][i]){
                dfs(i);
            }
        }

    }


}

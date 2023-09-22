package BOJ.dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TSP {

    static int N,minSpan=Integer.MAX_VALUE;
    static int[][]city;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i,j;

        N = Integer.parseInt(br.readLine());

        city=new int[N+1][N+1];

        for (i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (j = 1; j <= N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (i = 2; i <= N; i++) {
            boolean[] visited = new boolean[N + 1];
            visited[1]=true;

            if(city[1][i]==0)continue;
            visited[i]=true;
            dfs(visited, i, city[1][i],2);
            visited[i]=false;
        }

        System.out.println(minSpan);
    }

    private static void dfs(boolean[] visited, int num, int span,int cnt) {
        if(cnt==N){
            if(city[num][1]==0)return;
            minSpan=Math.min(minSpan,span+city[num][1]);
            return;
        }
        int i;

        for (i = 2; i <= N; i++) {

            if (visited[i] || city[num][i] == 0) continue;

            visited[i]=true;
            dfs(visited, i,span+city[num][i],cnt+1);
            visited[i]=false;
        }
    }
}

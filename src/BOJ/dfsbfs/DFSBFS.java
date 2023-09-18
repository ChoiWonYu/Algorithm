package BOJ.dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class DFSBFS {

    public static boolean[][] graph ;
    public static int n;
    public static StringBuffer sb;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        sb = new StringBuffer();
        n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int v = Integer.parseInt(input[2]);

        int num1,num2;

        graph=new boolean[n+1][n+1];
        boolean[] dfsVisited = new boolean[n + 1];
        boolean[] bfsVisited = new boolean[n + 1];
        for(int i=0;i<m;i++){
            input=br.readLine().split(" ");
            num1=Integer.parseInt(input[0]);
            num2 = Integer.parseInt(input[1]);

            graph[num1][num2]=true;
            graph[num2][num1]=true;
        }
        dfs(dfsVisited,v);
        sb.append("\n");
        bfs(bfsVisited, v);
        System.out.println(sb);
    }

    private static void bfs(boolean[] visited, int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        while (!q.isEmpty()) {
            int len=q.size();
            for (int i = 0;i<len; i++) {
                int cur = q.poll();
                visited[cur]=true;
                sb.append(cur).append(" ");
                for (int j = 1; j <= n; j++) {
                    if(graph[cur][j]&&!visited[j]){
                        visited[j]=true;
                        q.offer(j);
                    }
                }
            }
        }
    }

    private static void dfs(boolean[] visited, int v) {
        sb.append(v).append(" ");
        visited[v]=true;
        for (int i = 1; i <= n; i++) {
            if(graph[v][i]&&!visited[i]){
                dfs(visited,i);
            }
        }
    }


}

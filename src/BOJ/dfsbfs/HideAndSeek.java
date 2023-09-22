package BOJ.dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class HideAndSeek {
    static boolean[] visited = new boolean[100001];
    static int maxNum=100000;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int subinLoc = Integer.parseInt(st.nextToken());
        int sisterLoc = Integer.parseInt(st.nextToken());
        int cnt;

        cnt=bfs(subinLoc, sisterLoc);

        System.out.println(cnt);
    }

    private static int bfs(int subinLoc, int sisterLoc) {
        if(subinLoc==sisterLoc)return 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(subinLoc);

        int curLoc,len,i,cnt=0;
        int[] nextLoc = new int[3];


        while (!q.isEmpty()) {
            len = q.size();
            cnt++;

            for (i = 0; i < len; i++) {
                curLoc=q.poll();
                nextLoc[0]=curLoc+1;
                nextLoc[1]=curLoc-1;
                nextLoc[2]=curLoc*2;

                for (int loc : nextLoc) {
                    if(loc==sisterLoc)return cnt;
                    offerNextLocToQueue(q,loc);
                }
            }

        }
        return cnt;
    }

    private static void offerNextLocToQueue(Queue<Integer> q, int loc) {
        if(!isValidLoc(loc))return;
        visited[loc]=true;
        q.offer(loc);
    }

    private static boolean isValidLoc(int loc) {
        return loc>=0&&loc<=100000&&!visited[loc];
    }
}

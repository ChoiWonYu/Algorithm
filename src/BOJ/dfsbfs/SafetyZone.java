package BOJ.dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class SafetyZone {

    static int n;
    static int [][] zone,dir=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Set<Integer> s = new HashSet<>();
        n = Integer.parseInt(br.readLine());

        zone = new int[n][n];

        int i,j,inputNum,maxCnt=1;

        for(i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for (j = 0; j < n; j++) {
                inputNum=Integer.parseInt(st.nextToken());
                zone[i][j]=inputNum;
                s.add(inputNum);
            }
        }

        for (int dangerZone : s) {
            maxCnt=Math.max(maxCnt,getSafetyZoneCnt(dangerZone));
        }

        System.out.println(maxCnt);
    }

    private static int getSafetyZoneCnt(int dangerZone) {
        int i,j,cnt=0;
        boolean[][]visited=new boolean[n][n];
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if(!visited[i][j]&&zone[i][j]>dangerZone){
                    cnt++;
                    findSafetyZones(i,j,visited,dangerZone);
                }
            }
        }
        return cnt;
    }

    private static void findSafetyZones(int row, int col,boolean[][] visited,int dangerZone) {
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{row, col});

        int len,i,j,tmpRow,tmpCol;
        int[] cur;

        while (!q.isEmpty()) {
            len=q.size();
            for (i = 0; i < len; i++) {
                cur=q.poll();
                for (j = 0; j < 4; j++) {
                    tmpRow=cur[0]+dir[j][0];
                    tmpCol=cur[1]+dir[j][1];

                    if(isValid(tmpRow,tmpCol,visited,dangerZone)){
                        visited[tmpRow][tmpCol]=true;
                        q.offer(new int[]{tmpRow,tmpCol});
                    }
                }
            }
        }
    }

    private static boolean isValid(int tmpRow, int tmpCol,boolean[][] visited,int dangerZone) {
        return tmpRow>=0&&tmpRow<n&&tmpCol>=0&&tmpCol<n
                &&!visited[tmpRow][tmpCol]&&zone[tmpRow][tmpCol]>dangerZone;
    }
}

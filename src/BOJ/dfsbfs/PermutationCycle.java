package BOJ.dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PermutationCycle {

    static int startNum,resultCnt;
    static boolean[][] graph;
    static boolean[]visited;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len,i,j,m,t = Integer.parseInt(br.readLine());
        int[] nums;

        for (i = 0; i < t; i++) {
            len = Integer.parseInt(br.readLine());
            nums = new int[len];
            resultCnt=0;
            graph = new boolean[len+1][len+1];
            visited=new boolean[len+1];
            nums= Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            for (j = 1; j <= nums.length; j++) {
                graph[j][nums[j-1]]=true;
            }

            for (m = 1; m <= nums.length; m++) {
                if(!visited[m]){
                    startNum=m;
                    dfs(m);
                }
            }

            System.out.println(resultCnt);
        }


    }

    private static void dfs(int num) {
        visited[num]=true;
        int i;
        for (i = 0; i < graph.length; i++) {
            if(graph[num][i]){
                if(startNum==i) {
                    resultCnt++;
                    return;
                }

                if(!visited[i])dfs(i);
            }
        }
    }

}

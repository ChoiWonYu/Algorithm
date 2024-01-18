package BOJ.graph;

import java.io.*;
import java.util.*;

public class Bridge {

    static boolean[][] visited;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static int n;
    static int[][] map;
    static List<Set<int[]>> edge = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //섬들 찾기
        int islandNum = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    edge.add(new HashSet<>());
                    edge.get(islandNum - 1).add(new int[]{i, j});
                    dfs(i, j, islandNum++);
                }
            }
        }

        //거리 구하기
        int minDis = Integer.MAX_VALUE;
        int distance;
        for (int i = 0; i < edge.size(); i++) {
            islandNum = i + 1;
            distance = 0;
            visited = new boolean[n][n];
            Deque<int[]> d = new LinkedList<>(edge.get(i));
            while (!d.isEmpty()) {
                int len = d.size();
                distance++;
                for (int j = 0; j < len; j++) {
                    if (d.isEmpty()) {
                        break;
                    }
                    int[] cur = d.poll();

                    for (int k = 0; k < dx.length; k++) {
                        int curX = cur[0] + dx[k];
                        int curY = cur[1] + dy[k];
                        if (curX < 0 || curY < 0 || curX >= n || curY >= n || visited[curX][curY]) {
                            continue;
                        }
                        if (map[curX][curY] != 0 && map[curX][curY] != islandNum) {
                            minDis = Math.min(distance - 1, minDis);
                            d.clear();
                            break;
                        }
                        visited[curX][curY] = true;

                        d.add(new int[]{curX, curY});
                    }
                }
            }
        }

        System.out.println(minDis);
    }

    private static void dfs(int x, int y, int islandNum) {
        visited[x][y] = true;
        map[x][y] = islandNum;

        for (int i = 0; i < dx.length; i++) {
            int curX = x + dx[i];
            int curY = y + dy[i];

            if (curX < 0 || curY < 0 || curX >= n || curY >= n || visited[curX][curY]) {
                continue;
            }

            if (map[curX][curY] == 0) {
                edge.get(islandNum - 1).add(new int[]{x, y});
                continue;
            }

            dfs(curX, curY, islandNum);
        }

    }

}

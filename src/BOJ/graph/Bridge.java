package BOJ.graph;

import java.io.*;
import java.util.*;

public class Bridge {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Set<int[]>> edge = new ArrayList<>();

        //섬들 찾기
        int islandCnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                islandCnt++;
                map[i][j] = islandCnt;
                edge.add(new HashSet<>());
                edge.get(islandCnt - 1).add(new int[]{i, j});
                Deque<int[]> d = new LinkedList<>();
                d.add(new int[]{i, j});
                while (!d.isEmpty()) {
                    int len = d.size();
                    for (int k = 0; k < len; k++) {
                        int[] cur = d.poll();

                        for (int l = 0; l < dx.length; l++) {
                            int curX = cur[0] + dx[l];
                            int curY = cur[1] + dy[l];
                            if (curX < 0 || curY < 0 || curX >= n || curY >= n) {
                                continue;
                            }

                            if (map[curX][curY] == 0) {
                                edge.get(islandCnt - 1).add(new int[]{cur[0], cur[1]});
                                visited[curX][curY] = true;
                                continue;
                            }
                            if (visited[curX][curY]) {
                                continue;
                            }

                            visited[curX][curY] = true;
                            map[curX][curY] = islandCnt;
                            d.add(new int[]{curX, curY});
                        }
                    }
                }
            }
        }

        //거리 구하기
        int minDis = Integer.MAX_VALUE;
        int islandNum;
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

}

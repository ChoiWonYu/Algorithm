package Programmers.dfsbfs;

import java.util.*;

public class GameMap {

    public int solution(int[][] maps) {
        int[] dr = new int[]{0, 0, 1, -1};
        int[] dc = new int[]{1, -1, 0, 0};
        int rLimit = maps.length;
        int cLimit = maps[0].length;
        boolean[][] visited = new boolean[maps.length][maps[0].length];

        Deque<int[]> d = new LinkedList<>();
        d.add(new int[]{0, 0});
        int result = 1;

        while (!d.isEmpty()) {
            int len = d.size();
            for (int i = 0; i < len; i++) {
                int[] cur = d.poll();
                for (int j = 0; j < dr.length; j++) {
                    int nextR = cur[0] + dr[j];
                    int nextC = cur[1] + dc[j];
                    if (nextR == rLimit - 1 && nextC == cLimit - 1) {
                        return result + 1;
                    }

                    if (nextR < 0 || nextR >= rLimit
                        || nextC < 0 || nextC >= cLimit
                        || visited[nextR][nextC] || maps[nextR][nextC] == 0) {
                        continue;
                    }

                    visited[nextR][nextC] = true;
                    d.add(new int[]{nextR, nextC});
                }
            }
            result++;
        }
        return -1;
    }

}

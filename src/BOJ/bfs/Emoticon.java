package BOJ.bfs;

import java.io.*;
import java.util.*;

class Emoz {

    int cbCnt;
    int disCnt;

    public Emoz(final int cbCnt, final int disCnt) {
        this.cbCnt = cbCnt;
        this.disCnt = disCnt;
    }

    public boolean cbEmpty() {
        return cbCnt == 0;
    }

    public boolean disEmpty() {
        return disCnt == 0;
    }
}

public class Emoticon {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int s = Integer.parseInt(br.readLine());

        Deque<Emoz> d = new LinkedList<>();
        d.offer(new Emoz(0, 1));
        boolean[][] visited = new boolean[2000][2000];
        visited[0][1] = true;

        int result = 0;
        while (!d.isEmpty()) {
            int len = d.size();
            result++;
            for (int i = 0; i < len; i++) {
                Emoz cur = d.poll();
                if (!cur.cbEmpty() && cur.cbCnt + cur.disCnt < 1100 && !visited[cur.cbCnt][cur.cbCnt
                    + cur.disCnt]) {
                    //붙여넣기
                    if (cur.cbCnt + cur.disCnt == s) {
                        System.out.println(result);
                        return;
                    }
                    visited[cur.cbCnt][cur.cbCnt + cur.disCnt] = true;
                    d.add(new Emoz(cur.cbCnt, cur.cbCnt + cur.disCnt));
                }
                //복사
                if (!cur.disEmpty() && !visited[cur.disCnt][cur.disCnt]) {
                    visited[cur.disCnt][cur.disCnt] = true;
                    d.add(new Emoz(cur.disCnt, cur.disCnt));
                }

                //삭제
                if (cur.disCnt - 1 == s) {
                    System.out.println(result);
                    return;
                }
                if (cur.disCnt >= 1 && !visited[cur.cbCnt][cur.disCnt - 1]) {
                    visited[cur.cbCnt][cur.disCnt - 1] = true;
                    d.add(new Emoz(cur.cbCnt, cur.disCnt - 1));
                }
            }
        }
    }

}

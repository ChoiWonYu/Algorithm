package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ20056 {

    static int N, M;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static List<List<Deque<FireBall>>> map;
    static List<List<Deque<FireBall>>> tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new ArrayList<>();
        tmp = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            map.add(new ArrayList<>());
            tmp.add(new ArrayList<>());
            for (int j = 0; j < N; j++) {
                map.get(i).add(new LinkedList<>());
                tmp.get(i).add(new LinkedList<>());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            map.get(r - 1).get(c - 1).add(new FireBall(m, s, d));
        }

        for (int i = 0; i < k; i++) {
            moveBalls();
        }

        int answer = calculateSum();
        System.out.println(answer);
    }

    private static int calculateSum() {
        // 합 구하기
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                while (!map.get(i).get(j).isEmpty()) {
                    sum += map.get(i).get(j).poll().m;
                }
            }
        }
        return sum;
    }

    private static void moveBalls() {
        // 이동
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int len = map.get(i).get(j).size();
                for (int k = 0; k < len; k++) {
                    FireBall ball = map.get(i).get(j).poll();
                    move(i, j, ball);
                }
            }
        }

        List<List<Deque<FireBall>>> swap = map;
        map = tmp;
        tmp = swap;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map.get(i).get(j).size() > 1) {
                    // 합치기
                    combineBalls(i, j);
                }
            }
        }
    }

    private static void combineBalls(final int r, final int c) {
        int mSum = 0;
        int sSum = 0;
        int oddCnt = 0;
        int evenCnt = 0;
        int cnt = 0;
        Deque<FireBall> stack = map.get(r).get(c);
        while (!stack.isEmpty()) {
            FireBall ball = stack.poll();
            cnt++;
            mSum += ball.m;
            sSum += ball.s;
            if (ball.d % 2 == 0) {
                evenCnt++;
            } else {
                oddCnt++;
            }
        }

        int m = mSum / 5;
        int s = sSum / cnt;
        if (m == 0) {
            return;
        }

        if (oddCnt == cnt || evenCnt == cnt) {
            map.get(r).get(c).add(new FireBall(m, s, 0));
            map.get(r).get(c).add(new FireBall(m, s, 2));
            map.get(r).get(c).add(new FireBall(m, s, 4));
            map.get(r).get(c).add(new FireBall(m, s, 6));
        } else {
            map.get(r).get(c).add(new FireBall(m, s, 1));
            map.get(r).get(c).add(new FireBall(m, s, 3));
            map.get(r).get(c).add(new FireBall(m, s, 5));
            map.get(r).get(c).add(new FireBall(m, s, 7));
        }
    }

    private static void move(int r, int c, FireBall ball) {
        int nextR = r + (dr[ball.d] * ball.s);
        int nextC = c + (dc[ball.d] * ball.s);
        nextR = (nextR % N + N) % N;
        nextC = (nextC % N + N) % N;
        tmp.get(nextR).get(nextC).add(new FireBall(ball.m, ball.s, ball.d));
    }
}

class FireBall {

    int m;
    int s;
    int d;

    public FireBall(int m, int s, int d) {
        this.m = m;
        this.s = s;
        this.d = d;
    }
}

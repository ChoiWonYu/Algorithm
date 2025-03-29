package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Tower {

    int num;
    int height;

    public Tower(int num, int height) {
        this.num = num;
        this.height = height;
    }
}

public class BOJ2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Tower> towers = new LinkedList<>();
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            Tower cur = new Tower(i, Integer.parseInt(st.nextToken()));
            while (!towers.isEmpty() && towers.peekLast().height < cur.height) {
                towers.pollLast();
            }
            if (towers.isEmpty()) {
                answer = 0;
            } else {
                answer = towers.peekLast().num;
            }
            towers.add(cur);
            sb.append(answer).append(" ");
        }
        System.out.println(sb);
    }
}

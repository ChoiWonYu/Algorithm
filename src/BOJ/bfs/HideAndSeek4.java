package BOJ.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideAndSeek4 {

    static boolean[] visited = new boolean[100001];
    static int maxNum = 100000;

    public static int bfs(int startNum, int dest) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(startNum);
        int cnt = 0, len, cur, num, minusNum, plusNum;

        while (!q.isEmpty()) {
            len = q.size();
            for (int i = 0; i < len; i++) {
                cur = q.poll();
                q.offer(cur);
                num = cur;
                if (num == dest) {
                    return cnt;
                }

                while (true) {
                    if (num == 0) {
                        break;
                    }
                    num *= 2;
                    if (num == dest) {
                        return cnt;
                    }
                    if (num > maxNum) {
                        break;
                    }
                    if (visited[num]) {
                        continue;
                    }

                    visited[num] = true;
                    q.offer(num);

                    if (num > dest) {
                        break;
                    }
                }
            }
            len = q.size();
            cnt++;
            for (int i = 0; i < len; i++) {
                cur = q.poll();
                num = cur;
                minusNum = num - 1;
                plusNum = num + 1;

                if (minusNum == dest) {
                    return cnt;
                }
                if (plusNum == dest) {
                    return cnt;

                }

                if (minusNum >= 0 && !visited[minusNum]) {
                    q.offer(minusNum);
                    visited[minusNum] = true;
                }

                if (plusNum <= maxNum && !visited[plusNum]) {
                    q.offer(plusNum);
                    visited[plusNum] = true;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int count = bfs(n, m);

        System.out.println(count);
    }

}

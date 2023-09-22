package template;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bfs {

    public static void bfs(int num) {
        Queue<Integer> q = new LinkedList();
        q.offer(num);
        int len,curNum,i;

        while (!q.isEmpty()) {
            len=q.size();
            for (i = 0; i < len; i++) {
                curNum=q.poll();
            }
        }
    }

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int i;
    }
}

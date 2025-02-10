package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1713 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int reNum = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return a[2] - b[2];
            }
            return a[1] - b[1];
        });
        for (int i = 0; i < reNum; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (containNum(cur, pq)) {
                for (int[] arr : pq) {
                    if (arr[0] == cur) {
                        pq.add(new int[]{arr[0], arr[1] + 1, arr[2]});
                        pq.remove(arr);
                        break;
                    }
                }
            } else {
                if (pq.size() >= n) {
                    pq.poll();
                }
                pq.add(new int[]{cur, 1, i});
            }

        }

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll()[0]);
        }
        Collections.sort(result);
        for (int student : result) {
            System.out.print(student + " ");
        }
    }

    private static boolean containNum(final int cur, final PriorityQueue<int[]> pq) {
        for (int[] n : pq) {
            if (n[0] == cur) {
                return true;
            }
        }
        return false;
    }

}

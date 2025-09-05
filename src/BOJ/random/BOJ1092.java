package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1092 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> cranes = new ArrayList<>();
        List<Integer> loads = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            cranes.add(Integer.parseInt(st.nextToken()));
        }
        cranes.sort(Comparator.reverseOrder());

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            loads.add(Integer.parseInt(st.nextToken()));
        }
        loads.sort(Comparator.reverseOrder());

        Deque<Integer> l = new LinkedList<>(loads);
        Deque<Integer> d = new LinkedList<>(cranes);
        int cnt = 1;
        while (!d.isEmpty()) {
            int len = d.size();
            for (int i = 0; i < len; i++) {
                int cur = d.poll();

                if (cur < l.peekLast()) {
                    for (int j = 0; j < len - i - 1; j++) {
                        d.poll();
                    }
                    break;
                }
                if (cur >= l.peekFirst()) {
                    l.poll();
                    if (l.isEmpty()) {
                        System.out.println(cnt);
                        return;
                    }
                } else {
                    for (int num : l) {
                        if (cur >= num) {
                            l.remove(num);
                            break;
                        }
                    }
                }
                d.add(cur);
            }
            cnt++;
        }

        System.out.println(-1);
    }
}

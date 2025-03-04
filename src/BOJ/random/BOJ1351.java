package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1351 {

    static int p, q;
    static Map<Long, Long> m = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        m.put(0L, 1L);
        System.out.println(getResult(n));
    }

    public static long getResult(long i) {
        if (m.containsKey(i)) {
            return m.get(i);
        }

        long result = getResult(i / p) + getResult(i / q);
        m.put(i, result);
        return result;
    }
}

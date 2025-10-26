package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2961 {

    static int N, S, B;
    static Flavor[] flavors;
    static long answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        flavors = new Flavor[N];
        S = 1;
        B = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            flavors[i] = new Flavor(x, y);
        }

        comb(-1);
        System.out.println(answer);
    }

    public static void comb(int prevIdx) {

        for (int i = prevIdx + 1; i < N; i++) {
            int prevS = S;
            int prevB = B;
            S = S * flavors[i].s;
            B = B + flavors[i].b;
            answer = Math.min(answer, Math.abs(S - B));
            comb(i);
            S = prevS;
            B = prevB;
        }
    }
}

class Flavor {

    int s;
    int b;

    Flavor(int s, int b) {
        this.s = s;
        this.b = b;
    }
}

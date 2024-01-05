package BOJ.bruteForce;

import java.io.*;
import java.util.*;

public class CalculateDate {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int ed, sd, md;
        int num = 1;
        while (true) {
            ed = num % 15 == 0 ? 15 : num % 15;
            sd = num % 28 == 0 ? 28 : num % 28;
            md = num % 19 == 0 ? 19 : num % 19;

            if (ed == e && sd == s && md == m) {
                System.out.println(num);
                return;
            }
            num++;
        }
    }

}

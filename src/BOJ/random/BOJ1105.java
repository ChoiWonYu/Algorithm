package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1105 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n1 = st.nextToken();
        String n2 = st.nextToken();

        StringBuilder ns1 = new StringBuilder(n1);
        StringBuilder ns2 = new StringBuilder(n2);
        ns1.reverse();
        ns2.reverse();

        int answer = 0;
        int p1 = 0;
        int p2 = 0;

        while (p1 < ns1.length() && p2 < ns2.length()) {
            if (ns1.charAt(p1) == ns2.charAt(p2)) {
                if (ns2.charAt(p1) == '8') {
                    answer++;
                }
            } else {
                answer = 0;
            }
            p1++;
            p2++;
        }
        System.out.println(p2 == ns2.length() ? answer : 0);
    }

}

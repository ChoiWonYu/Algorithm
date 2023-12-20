package BOJ.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseWord2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder reverseSb = new StringBuilder();
        String target = br.readLine();
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == '<') {
                sb.append(reverseSb.reverse());
                sb.append("<");
                while (target.charAt(++i) != '>') {
                    sb.append(target.charAt(i));
                }
                sb.append(">");
                reverseSb.setLength(0);
                continue;
            }
            if (target.charAt(i) == ' ') {
                sb.append(reverseSb.reverse()).append(" ");
                reverseSb.setLength(0);
                continue;
            }
            reverseSb.append(target.charAt(i));
        }
        sb.append(reverseSb.reverse()).append(" ");
        reverseSb.setLength(0);
        System.out.println(sb);
    }
}

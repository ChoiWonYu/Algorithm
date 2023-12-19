package BOJ.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class ReverseWord {

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String target;
        Stack<Character> s = new Stack<>();

        int i,num = Integer.parseInt(br.readLine());
        for (i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                target = st.nextToken();
                target.chars()
                    .forEach(ch->{
                        s.push((char)ch);
                    });
                while (!s.empty()) {
                    sb.append(s.pop());
                }
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

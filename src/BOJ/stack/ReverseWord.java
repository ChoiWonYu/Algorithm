package BOJ.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReverseWord {

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        StringBuilder reverseSb = new StringBuilder();
        String target;

        int i,num = Integer.parseInt(br.readLine());
        for (i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                target = st.nextToken();
                reverseSb.append(target).reverse();
                sb.append(reverseSb).append(" ");
                reverseSb.delete(0,reverseSb.length());
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

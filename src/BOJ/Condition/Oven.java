package BOJ.Condition;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Oven {
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        StringBuilder sb=new StringBuilder();
        int h=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        int t=Integer.parseInt(br.readLine());

        t+=m;
        h+=t/60;
        h%=24;

        m=t%60;


        sb.append(h).append(' ').append(m);
        System.out.println(sb);
    }
}

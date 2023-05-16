package BOJ.Condition;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;


public class Alarm {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int h=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        if(m<45){
            if(h==0)h=23;
            else h-=1;

            m+=15;
        }
        else{
            m-=45;
        }
        StringBuilder sb=new StringBuilder();
        sb.append(h).append(' ').append(m);
        System.out.println(sb);
    }

    public static class Oven {
    }
}
package BOJ.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CharString {
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        String s=br.readLine();
        int num=Integer.parseInt(br.readLine());

        sb.append(s);

        System.out.println(sb.substring(num-1,num));

    }
}

package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringPractice {
    public static void main(java.lang.String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int n=Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            sb.delete(0,sb.length());
            String s=br.readLine();
            sb.append(s.charAt(0)).append(s.charAt(s.length()-1));
            System.out.println(sb.toString());
        }


    }
}

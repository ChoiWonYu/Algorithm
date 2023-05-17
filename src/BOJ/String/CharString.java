package BOJ.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CharString {
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        String s=br.readLine();
        int num=Integer.parseInt(br.readLine());

        System.out.println(s.charAt(num-1));
        //문자열 문자 인덱싱 charAt
    }
}

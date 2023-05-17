package BOJ.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringLength {
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        String s=br.readLine();

        System.out.println(s.length());
    }
}

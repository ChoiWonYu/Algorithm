package BOJ.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrintString {
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String s=br.readLine();
            if(s==null||s.isBlank()){
                break;
            }
            System.out.println(s);
        }
    }
}

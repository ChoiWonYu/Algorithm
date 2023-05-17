package BOJ.Intensify1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Word {
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine().toUpperCase();

        HashMap<Character,Integer> h=new HashMap<Character,Integer>();
        int max=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(h.get(c)==null){
                h.put(c,1);
            }
            else{
                h.put(c,h.get(c)+1);
            }
            if(h.get(c)>max){
                max=h.get(c);
            }
        }
        int flag=0;
        char result=' ';
        for(char ch:h.keySet()){
            if(flag==1&&h.get(ch)==max){
                result='?';
                break;
            }

            if(h.get(ch)==max){
                flag=1;
                result=ch;
            }
        }

        System.out.println(result);

    }
}

package BOJ.Intensify1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Palindrome {
    static int isPalindrome(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)==s.charAt(s.length()-1-i))continue;
            else return 0;
        }
        return 1;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();

        int result=isPalindrome(s);

        System.out.println(result);
    }
}

package inflearn.string;

import java.util.*;

public class ReverseWord {
    public static void printReverseWord(String s){
       StringBuilder sb=new StringBuilder();
       System.out.println(sb.append(s).reverse().toString());
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            printReverseWord(sc.next());
        }
    }
}

package Programmers.Sort;
import java.util.*;

public class Biggest {
    public static Comparator<String> comp=new Comparator<String>(){
        public int compare(String r,String l){
        return (l+r).compareTo(r+l);
    }
    };

    public static String solution(int[] numbers){
        String[] s=new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            s[i]=Integer.toString(numbers[i]);
        }
        Arrays.sort(s,comp);
        StringBuilder sb=new StringBuilder();
        for(String st:s)sb.append(st);

        return sb.toString();
    };


    public static void main(String[] args){
        int[] arr={3, 30, 34, 5, 9};
        String result=solution(arr);
        System.out.println(result);
    }

    };


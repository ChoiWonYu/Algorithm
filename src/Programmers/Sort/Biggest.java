package Programmers.Sort;
import java.util.*;

public class Biggest {
    public static ArrayList<String> solution(int[] numbers){
        ArrayList<String> result=new ArrayList<String>();
        for(int i=0;i<numbers.length;i++){
            StringBuilder sb=new StringBuilder();
            sb.append(numbers[i]);
            for(int j=0;j<numbers.length;j++){
                if(j!=i){
                    sb.append(numbers[j]);
                }
            }
            result.add(sb.toString());
        }
        return result;
    };


    public static void main(String[] args){
        int[] arr={3, 30, 34, 5, 9};
        ArrayList<String> result=solution(arr);
        for(String s:result){
            System.out.println(s);
        }
    }

}

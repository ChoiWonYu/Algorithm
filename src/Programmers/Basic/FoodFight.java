package Programmers.Basic;
import java.util.*;

public class FoodFight {
    public static String solution(int[] food) {
        String answer = "";
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<food.length;i++){
            for(int j=0;j<food[i]/2;j++){
                sb.append(i);
            }
        }
        sb.append("0");
        for(int i=food.length-1;i>0;i--){
            for(int j=0;j<food[i]/2;j++){
                sb.append(i);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args){
        String answer=solution(new int[] {1, 3, 4, 6});
        System.out.println(answer);
    }
}

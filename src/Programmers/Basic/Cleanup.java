package Programmers.Basic;
import java.util.*;

public class Cleanup {
    public int[] solution(String[] wallpaper) {
        int idx=0;
        int []min={Integer.MAX_VALUE,Integer.MAX_VALUE};
        int []max={Integer.MIN_VALUE,Integer.MIN_VALUE};
        for(String s:wallpaper)
        {
            for(int x=0;x<s.length();x++) {
                char token = s.charAt(x);
                if (token=='#'){
                    min[0]=Math.min(min[0],x);
                    min[1]=Math.min(min[1],idx);
                    max[0]=Math.max(max[0],x+1);
                    max[1]=Math.max(max[1],idx+1);
                }
            }

            idx++;
        }

        int[] answer = new int[4];
        answer[0]=min[1];
        answer[1]=min[0];
        answer[2]=max[1];
        answer[3]=max[0];
        return answer;
    }


    public static void main(String[] args){}

}

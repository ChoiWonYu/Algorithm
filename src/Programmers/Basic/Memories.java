package Programmers.Basic;
import java.util.*;

public class Memories {
    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String,Integer> m=new HashMap<>();
        for(int i=0;i<name.length;i++){
            m.put(name[i],yearning[i]);
        }
        int[] answer = new int[photo.length];
        int idx=0;
        for(int i=0;i<photo.length;i++){
            for(String s:photo[i]){
                if(m.get(s)==null)continue;
                answer[i]+=m.get(s);
            }
            idx++;
        }

        return answer;
    }

    public static void main(String[] args){
        String[ ]n={"may", "kein", "kain", "radi"};
        int[]y={5, 10, 1, 3};
        String[][]p={{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
        int []answer=solution(n,y,p);
        for(int i:answer)System.out.println(i);
    }

}

package Programmers.Basic;
import java.util.*;

public class Lotto {
        public static int[] solution(int[] lottos, int[] win_nums) {
            Arrays.sort(lottos);
            Arrays.sort(win_nums);
            int cnt=0;
            int z_cnt=0;
            int[] answer=new int[2];
            for(int i=0;i<lottos.length;i++){
                for(int j=0;j<win_nums.length;j++){
                    if(lottos[i]==win_nums[j])cnt++;
                }
                if(lottos[i]==0)z_cnt++;
            }
            answer[0]=cnt+z_cnt>1?6-(cnt+z_cnt)+1:6;
            answer[1]=cnt>1?6-cnt+1:6;
            return answer;
        }

    public static void main(String[ ]args){
        int[] lottos={44, 1, 0, 0, 31, 25};
        int[] win_nums={31, 10, 45, 1, 6, 19};
        int[]answer=solution(lottos,win_nums);
        System.out.println(Arrays.toString(answer));
    }
}

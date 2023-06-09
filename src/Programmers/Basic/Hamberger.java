package Programmers.Basic;
import java.util.*;

public class Hamberger {


    public static int solution(int[] ingredient) {
        int answer=0;
        int[] stack=new int[ingredient.length];
        int sp=0;
        for(int i:ingredient){
            stack[sp++]=i;
            if(sp>=4&&stack[sp-1]==1&&stack[sp-2]==3&&stack[sp-3]==2&&stack[sp-4]==1){
                sp-=4;
                //스택 포인터를 감소시켜 그 후 원소를 배열에 덮어쓰면 필요없는 원소를 삭제하고 그 뒤 원소를 당길 필요 없어짐
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        int result=solution(new int[] {2, 1, 1, 2, 3, 1, 2, 3, 1});
        System.out.println(result);
    }

}

package Programmers.Basic;

public class PlusMinus {
    public static int solution(int[] absolutes, boolean[] signs) {
        int answer=0;
        for(int i=0;i<absolutes.length;i++){
            answer+=signs[i]?absolutes[i]:-absolutes[i];
        }
        return answer;
    }

    public static void main(String[] args){
        int[ ]abs={4,7,12};
        boolean[] s={true,false,true};
        int result =solution(abs,s);
        System.out.println(result);
    }

}

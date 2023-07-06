package Programmers.Basic;

import java.util.Arrays;

public class Stage {
    public static int[] solution(int N, int[] stages) {
        S[] arr=new S[N];
        for(int i=0;i<N;i++){
            arr[i]=new S(i+1);
        }

        for(int j:stages){
            for(int i=0;i<N;i++){
                if(arr[i].stageNum<=j)arr[i].participate++;
            }
            if(j<=N)arr[j-1].fail++;
        }

        Arrays.sort(arr);

        int[] answer=new int[N];
        for(int i=0;i<N;i++){
            answer[N-i-1]=arr[i].stageNum;
        }

        return answer;
    }

    public static void main(String[]args){
        int[] a=new int[] {4};
        int[] result=solution(5, a);
        System.out.println(Arrays.toString(result));
    }
}

class S  implements Comparable<S>{
    public int stageNum;
    public int fail=0;
    public int participate=0;

    S(){}

    S(int stageNum){
        this.stageNum=stageNum;
    }

    @Override
    public int compareTo(S o) {
        int comp=fail*o.participate-o.fail*participate;
        return comp==0?o.stageNum-stageNum : comp;
    }
}
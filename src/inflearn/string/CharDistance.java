package inflearn.string;

import java.util.*;

public class CharDistance {
    public static int[] solution(String s,char ch){
        int[] answer=new int[s.length()];
        int idx=0;
        String[] splitArr=s.split(String.valueOf(ch));

        for(int i=0;i<splitArr.length;i++){
            int length = splitArr[i].length();
            for(int j=0;j<length;j++){
                if(i==0)answer[idx++]=length-j;
                else if(i==splitArr.length-1&&s.charAt(s.length()-1)!=ch)answer[idx++]=j+1;
                else answer[idx++]=Math.min(j+1,length-j);
            }
            if(idx<s.length())answer[idx++]=0;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] q=sc.nextLine().split(" ");
        int[] result=solution(q[0],q[1].charAt(0));

        for(int i:result){
            System.out.print(i+" ");
        }
    }
}

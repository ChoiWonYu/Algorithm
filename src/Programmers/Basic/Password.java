package Programmers.Basic;

public class Password {

    public static String solution(String s, String skip, int index) {
        StringBuilder answer=new StringBuilder();
        for(char targetChar:s.toCharArray()){
            char temp=targetChar;
            int idx=0;
            while(idx<index){
                temp=temp=='z'?'a':(char)(temp+1);
                if(!skip.contains(String.valueOf(temp))){
                    idx+=1;
                }
            }
            answer.append(temp);
        }
        return answer.toString();

    }

    public static void main(String[] args){
        String s="ybc";
        String skip="az";
        int index=1;
        String ans=solution(s,skip,index);
        System.out.println(ans);
    }
}

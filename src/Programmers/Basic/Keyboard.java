package Programmers.Basic;

public class Keyboard {
    public static int returnClick(String s,char c){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==c)return i+1;
        }
        return Integer.MAX_VALUE;
    }

    public static int getMinTouch(String target,String[] keymap){
        int touchSum=0;
        for(int i=0;i<target.length();i++){
            int touch=Integer.MAX_VALUE;
            char targetChar=target.charAt(i);
            for(String s:keymap){
                touch=Math.min(touch,returnClick(s,targetChar));
            }
            if(touch==Integer.MAX_VALUE)return -1;
            touchSum+=touch;
        }
        return touchSum;
    }

    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        for(int i=0;i<targets.length;i++){
            answer[i]=getMinTouch(targets[i],keymap);
        }

        return answer;
    }

    public static void main(String[] args){
        String[]keymap={"AGZ", "BSSS"};
        String[] targets={"ASA","BGZ"};
        int[]result=solution(keymap,targets);
        for(int i:result)System.out.println(i);
    }

}

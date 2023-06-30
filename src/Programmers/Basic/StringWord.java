package Programmers.Basic;

public class StringWord {
    public static int solution(String s) {
        String[] words={"zero","one","two","three","four","five","six","seven","eight","nine"};
        for(int i=0;i<words.length;i++){
            s=s.replace(words[i],Integer.toString(i));
        }
        return Integer.parseInt(s);
    }

    public static void main(String[] args){
        int result=solution("2three45sixseven");
        System.out.println(result);
    }
}
